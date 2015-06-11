package unitTests.OrdersProductsAndServices;

import DesignPatternsProject.entities.actors.Client;
import DesignPatternsProject.entities.orders.OrderDetails;
import DesignPatternsProject.entities.personalData.Address;
import DesignPatternsProject.entities.productsAndServices.Product;
import DesignPatternsProject.entities.productsAndServices.Service;
import DesignPatternsProject.strategies.Country;
import DesignPatternsProject.strategies.Currency;
import DesignPatternsProject.strategies.taxations.PolishTaxation08;
import DesignPatternsProject.strategies.taxations.TaxationStrategy;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lucjan on 30.04.15.
 */
public class OrderTest {

    @Test
    public void createSimpleOrderAttempt() {
        Country Poland = new Country("Poland", Currency.PLN, 1, 0);
        Assert.assertNotNull(Poland);

        TaxationStrategy poland08 = new PolishTaxation08(Poland);
        Assert.assertNotNull(poland08);


        Client client = new Client("allegro", "password", "allegro@gmail.com");
        Address address = new Address("Poland", "Warsaw", "Wiejska", "23-330 Warsaw");
        Assert.assertNotNull(address);
        client.setAddress(address);
        Assert.assertNotNull(client);


        OrderDetails orderDetails = new OrderDetails("12/03/2015", poland08, client);
        Assert.assertNotNull(orderDetails);

        orderDetails.addAnyBaseProduct(
                new Product("komputer", 2000),
                new Product("laptop", 3000),
                new Product("audi", 5000),
                new Service("konsultacje", 1000)
        );

        Assert.assertEquals(4, orderDetails.getContentSize());
        Assert.assertEquals(11*1000, orderDetails.getTotalNettoPrice(), 0.01);
        Assert.assertEquals(3, orderDetails.getOnlyProducts().size());
        Assert.assertEquals(1, orderDetails.getOnlyServices().size());
        Assert.assertEquals(client, orderDetails.getClient());
        Assert.assertEquals(address, orderDetails.getAddress());

        Assert.assertEquals((100+poland08.getTax())*11000/ 100 - 1500, orderDetails.calculateNewPriceByAmountDiscount(1500.0), 0.01);
        Assert.assertEquals((100+poland08.getTax())*11000/ 100 / 2, orderDetails.calculateNewPriceByPercentDiscount(50), 0.01);
        Assert.assertEquals((100+poland08.getTax())*11000/ 100, orderDetails.getTotalBruttoPrice(), 0.01);
    }
}
