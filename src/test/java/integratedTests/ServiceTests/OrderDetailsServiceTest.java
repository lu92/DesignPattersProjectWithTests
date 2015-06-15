package integratedTests.ServiceTests;

import DesignPatternsProject.DTO.OrderDetailsFormDTO;
import DesignPatternsProject.Neo4jTestApplication;
import DesignPatternsProject.entities.orders.AbstractOrderDetails;
import DesignPatternsProject.entities.orders.OrderDetails;
import DesignPatternsProject.entities.productsAndServices.Product;
import DesignPatternsProject.entities.productsAndServices.Service;
import DesignPatternsProject.repositories.BaseProductRepository;
import DesignPatternsProject.repositories.ClientRepository;
import DesignPatternsProject.resources.BaseProductResource;
import DesignPatternsProject.resources.ClientResource;
import DesignPatternsProject.services.OrderDetailsService;
import DesignPatternsProject.strategies.discounts.DiscountHandler;
import DesignPatternsProject.strategies.discounts.FreeConsulting;
import DesignPatternsProject.strategies.discounts.Rebate;
import DesignPatternsProject.strategies.discounts.RightLoyalty;
import DesignPatternsProject.strategies.taxations.TaxationStrategy;
import DesignPatternsProject.strategies.taxations.TaxationType;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;



/**
 * Created by lucjan on 14.06.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Neo4jTestApplication.class)
@Transactional
public class OrderDetailsServiceTest {

    @Autowired
    private BaseProductRepository baseProductRepository;

    @Autowired
    private OrderDetailsService orderDetailsService;

    @Autowired
    private ClientRepository clientRepository;


    @Test @Rollback(value = true)
    public void createOrder() {

        clientRepository.deleteAll();

        long clientId = clientRepository.save(ClientResource.getAnnaNowak()).getId();
        Assert.assertEquals(1, clientRepository.count());

        long id1 = baseProductRepository.save(new Product("komputer", 2000)).getId();
        long id2 = baseProductRepository.save(new Product("laptop", 3000)).getId();
        long id3 = baseProductRepository.save(new Product("audi", 5000)).getId();
        long id4 = baseProductRepository.save(new Service("konsultacje", 1000)).getId();


        OrderDetailsFormDTO orderDetailsFormDTO = new OrderDetailsFormDTO("12/03/2015", clientId, TaxationType.PolishTaxation08);
        orderDetailsFormDTO.addBaseProduct(id1, id2, id3, id4);

        Assert.assertEquals("12/03/2015", orderDetailsFormDTO.getDate());
        Assert.assertEquals(clientId, (long) orderDetailsFormDTO.getClientId());
        Assert.assertEquals(TaxationType.PolishTaxation08, orderDetailsFormDTO.getTaxationType());
        Assert.assertEquals(4, orderDetailsFormDTO.getBaseProductSet().size());

        Assert.assertNotNull(orderDetailsService);

        long orderId = orderDetailsService.createNewOrderDetails(orderDetailsFormDTO).getOrder_id();
        Assert.assertEquals(1, orderDetailsService.getNumberOfOrders());

        AbstractOrderDetails orderDetails = orderDetailsService.getOrderDetails(orderId);
        Assert.assertNotNull(orderDetails);

        orderDetails.loadTaxation();
        Assert.assertNotNull(orderDetails.getTaxation());


        orderDetailsService.addBaseProductToOrderDetails(orderId, id1);
        orderDetailsService.addBaseProductToOrderDetails(orderId, id2);
        orderDetailsService.addBaseProductToOrderDetails(orderId, id3);
        orderDetailsService.addBaseProductToOrderDetails(orderId, id4);

        Assert.assertNotNull(orderDetailsService.getOrderDetails(orderId));

        Assert.assertEquals("wlozylismy 3 produkty i 1 usluge", 4, orderDetailsService.getOrderDetails(orderId).getOrder().size());

        orderDetails = orderDetailsService.getOrderDetails(orderId);
        orderDetails.loadTaxation();

        Assert.assertEquals(4, orderDetails.getContentSize());
        Assert.assertEquals("liczymy cene netto calego koszyka", 11*1000, orderDetails.getTotalNettoPrice(), 0.01);
        Assert.assertEquals("jest 3 produkty", 3, orderDetails.getOnlyProducts().size());
        Assert.assertEquals("jest 1 usluga",1, orderDetails.getOnlyServices().size());
//        Assert.assertEquals("czy jest podpiety client", clientRepository.findOne(clientId), orderDetails.getClient());
//        Assert.assertEquals("adresem zamowienia jest adres clienta", clientRepository.findOne(clientId).getAddress(), orderDetails.getAddress());


        orderDetails = orderDetailsService.getOrderDetails(orderId);
        orderDetails.loadTaxation();
        Assert.assertNotNull(orderDetails);

        TaxationStrategy poland08 = orderDetails.getTaxation();
        Assert.assertNotNull(poland08);

        Assert.assertEquals((100+poland08.getTax())*11000/ 100 - 1500, orderDetails.calculateNewPriceByAmountDiscount(1500.0), 0.01);
        Assert.assertEquals((100+poland08.getTax())*11000/ 100 / 2, orderDetails.calculateNewPriceByPercentDiscount(50), 0.01);
        Assert.assertEquals((100+poland08.getTax())*11000/ 100, orderDetails.getTotalBruttoPrice(), 0.01);


        //  usuniecie uslugi z koszyka
        orderDetailsService.deleteBaseProductFromOrderDetails(orderId, id4);
        Assert.assertEquals("zawartosc koszyka to 3 produkty", 3, orderDetailsService.getOrderDetails(orderId).getOrder().size());
        Assert.assertEquals("sprawdzamy czy jest 3 produkty",3, orderDetailsService.getOrderDetails(orderId).getOnlyProducts().size());
        Assert.assertEquals("sprawdzamy czy jest 0 uslug bo wlasnie usunelismy", 0, orderDetailsService.getOrderDetails(orderId).getOnlyServices().size());

    }

    @Test   //  pokrywa RD1 RD3 RD9
    public void PT1() {
        clientRepository.deleteAll();

        long clientId = clientRepository.save(ClientResource.getAnnaNowak()).getId();
        Assert.assertEquals(1, clientRepository.count());

        long id1 = baseProductRepository.save(BaseProductResource.getAlgorithmLibrary()).getId();
        long id2 = baseProductRepository.save(BaseProductResource.getCRM()).getId();
        long id3 = baseProductRepository.save(BaseProductResource.getERP()).getId();
        long id4 = baseProductRepository.save(BaseProductResource.getMultiThreadingAlgorithmLibrary()).getId();
        long id5 = baseProductRepository.save(BaseProductResource.getSystemSecure()).getId();



        OrderDetailsFormDTO orderDetailsFormDTO = new OrderDetailsFormDTO("12/03/2015", clientId, TaxationType.PolishTaxation08);
        orderDetailsFormDTO.addBaseProduct(id1, id2, id3, id4, id5);

        Assert.assertEquals("12/03/2015", orderDetailsFormDTO.getDate());
        Assert.assertEquals(clientId, (long) orderDetailsFormDTO.getClientId());
        Assert.assertEquals(TaxationType.PolishTaxation08, orderDetailsFormDTO.getTaxationType());
        Assert.assertEquals(5, orderDetailsFormDTO.getBaseProductSet().size());

        Assert.assertNotNull(orderDetailsService);

        long orderId = orderDetailsService.createNewOrderDetails(orderDetailsFormDTO).getOrder_id();
        Assert.assertEquals(1, orderDetailsService.getNumberOfOrders());

        AbstractOrderDetails orderDetails = orderDetailsService.getOrderDetails(orderId);
        Assert.assertNotNull(orderDetails);

        orderDetails.loadTaxation();
        Assert.assertNotNull(orderDetails.getTaxation());


        orderDetailsService.addBaseProductToOrderDetails(orderId, id1);
        orderDetailsService.addBaseProductToOrderDetails(orderId, id2);
        orderDetailsService.addBaseProductToOrderDetails(orderId, id3);
        orderDetailsService.addBaseProductToOrderDetails(orderId, id4);
        orderDetailsService.addBaseProductToOrderDetails(orderId, id5);
        Assert.assertNotNull(orderDetailsService.getOrderDetails(orderId));

        Assert.assertEquals("wlozylismy 5 produktow", 5, orderDetailsService.getOrderDetails(orderId).getOrder().size());

        orderDetails = orderDetailsService.getOrderDetails(orderId);
        orderDetails.loadTaxation();

        Assert.assertEquals(5, orderDetails.getContentSize());
//        Assert.assertEquals("czy jest podpiety client", clientRepository.findOne(clientId), orderDetails.getClient());
//        Assert.assertEquals("adresem zamowienia jest adres clienta", clientRepository.findOne(clientId).getAddress(), orderDetails.getAddress());


        Assert.assertTrue(orderDetails.getTotalBruttoPrice() > 100 * 1000);
        Assert.assertTrue(orderDetails.getTotalBruttoPrice() > 300 * 1000);
        Assert.assertTrue(orderDetails.getTotalBruttoPrice() > 2 * 1000 * 1000);

        DiscountHandler discountHandler = new DiscountHandler(orderDetails);
        discountHandler.addDiscountCondition(
                new Rebate(100* 1000, 1.5), new FreeConsulting(300 * 1000), new RightLoyalty());
        Assert.assertNotNull(discountHandler);

        Assert.assertTrue(discountHandler.getDiscountNotification().isGrantedRebate());
        Assert.assertTrue(discountHandler.getDiscountNotification().isGrantedFreeConsulting());
        Assert.assertTrue(discountHandler.getDiscountNotification().isGrantedRightLoyalty());

    }

}
