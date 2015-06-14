package integratedTests;

import DesignPatternsProject.Neo4jTestApplication;

import DesignPatternsProject.entities.actors.Client;
import DesignPatternsProject.entities.orders.AbstractOrderDetails;
import DesignPatternsProject.entities.orders.OrderDetails;
import DesignPatternsProject.entities.personalData.Address;
import DesignPatternsProject.entities.productsAndServices.Product;
import DesignPatternsProject.entities.productsAndServices.Service;
import DesignPatternsProject.repositories.ClientRepository;
import DesignPatternsProject.repositories.CountryRepository;
import DesignPatternsProject.repositories.OrderDetailsRepository;
import DesignPatternsProject.repositories.PersonRepository;
import DesignPatternsProject.resources.ClientResource;
import DesignPatternsProject.strategies.Country;
import DesignPatternsProject.strategies.Currency;
import DesignPatternsProject.strategies.taxations.PolishTaxation08;
import DesignPatternsProject.strategies.taxations.TaxationStrategy;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by lucjan on 12.06.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Neo4jTestApplication.class)
@Transactional
public class OrderDetailsTest {


    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;


    @Autowired
    private CountryRepository countryRepository;

    @Test @Rollback(true)
    public void saveOrder() {
        personRepository.deleteAll();
        Country Poland = new Country("Poland", Currency.PLN, 1, 0);

        countryRepository.save(Poland);
        Assert.assertEquals(1, countryRepository.count());
        TaxationStrategy poland08 = new PolishTaxation08(Poland);

        clientRepository.save(ClientResource.getPiotrKraus());
        Assert.assertEquals(1, clientRepository.count());


        AbstractOrderDetails orderDetails = new OrderDetails("12/03/2015", poland08, ClientResource.getPiotrKraus());
        Assert.assertNotNull(orderDetails);

        orderDetails.addAnyBaseProduct(
                new Product("komputer", 2000),
                new Product("laptop", 3000),
                new Product("audi", 5000),
                new Service("konsultacje", 1000)
        );

        long orderId = orderDetailsRepository.save(orderDetails).getOrder_id();
        Assert.assertEquals(1, orderDetailsRepository.count());

        Assert.assertEquals(4, orderDetailsRepository.findOne(orderId).getOrder().size());
        Assert.assertEquals(new Date("12/03/2015"), orderDetailsRepository.findOne(orderId).getDate());
        Assert.assertNotNull(orderDetailsRepository.findOne(orderId).getClient());
        Assert.assertEquals(ClientResource.getPiotrKraus().getAddress(), orderDetailsRepository.findOne(orderId).getAddress());

        AbstractOrderDetails orderDetailsDb = orderDetailsRepository.findOne(orderId);
        orderDetailsDb.loadTaxation();
        Assert.assertNotNull(orderDetailsDb.getTaxationType());
        Assert.assertNotNull(orderDetailsDb.getTaxation());
    }


}
