package integratedTests.ServiceTests;

import DesignPatternsProject.DTO.OrderDetailsFormDTO;
import DesignPatternsProject.Neo4jTestApplication;
import DesignPatternsProject.entities.orders.AbstractOrderDetails;
import DesignPatternsProject.entities.orders.OrderDetails;
import DesignPatternsProject.entities.productsAndServices.Product;
import DesignPatternsProject.entities.productsAndServices.Service;
import DesignPatternsProject.repositories.BaseProductRepository;
import DesignPatternsProject.repositories.ClientRepository;
import DesignPatternsProject.resources.ClientResource;
import DesignPatternsProject.services.OrderDetailsService;
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

        long clientId = clientRepository.save(ClientResource.getPiotrKraus()).getId();


        long id1 = baseProductRepository.save(new Product("komputer", 2000)).getId();
        long id2 = baseProductRepository.save(new Product("laptop", 3000)).getId();
        long id3 = baseProductRepository.save(new Product("audi", 5000)).getId();
        long id4 = baseProductRepository.save(new Service("konsultacje", 1000)).getId();


        OrderDetailsFormDTO orderDetailsFormDTO = new OrderDetailsFormDTO("12/03/2015", clientId, TaxationType.PolishTaxation23);
        orderDetailsFormDTO.addBaseProduct(id1, id2, id3, id4);

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

        Assert.assertEquals(4, orderDetailsService.getOrderDetails(orderId).getOrder().size());

        orderDetailsService.deleteBaseProductFromOrderDetails(orderId, id4);
        Assert.assertEquals(3, orderDetailsService.getOrderDetails(orderId).getOrder().size());
        Assert.assertEquals(3, orderDetailsService.getOrderDetails(orderId).getOnlyProducts().size());
        Assert.assertEquals(0, orderDetailsService.getOrderDetails(orderId).getOnlyServices().size());

    }

}
