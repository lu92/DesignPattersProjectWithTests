package unitTests;

import DesignPatternsProject.entities.orders.OrderDetails;
import DesignPatternsProject.entities.productsAndServices.Product;
import DesignPatternsProject.entities.productsAndServices.Service;
import DesignPatternsProject.resources.CategoryResources;
import DesignPatternsProject.resources.ClientResource;
import DesignPatternsProject.strategies.Country;
import DesignPatternsProject.strategies.Currency;
import DesignPatternsProject.strategies.taxations.PolishTaxation08;
import DesignPatternsProject.strategies.taxations.UsaTaxation;
import org.junit.Assert;
import org.junit.Test;

import java.util.Date;

/**
 * Created by lucjan on 05.06.15.
 */
public class CalculateThePricesOfTheOrder {

    @Test
    public void OrderWithPolishTaxation08() {
        OrderDetails orderDetails = new OrderDetails(
                "12/05/2015", new PolishTaxation08(new Country("Poland", Currency.PLN, 1.0, 0)),
                ClientResource.getAnnaNowak());

        Assert.assertNotNull(orderDetails);

        orderDetails.addAnyBaseProduct(
                new Product("CRM", 100*1000),
                new Service("wdrazenie CRM", 20*1000)
        );

        Assert.assertEquals(2, orderDetails.getContentSize());
        Assert.assertNotNull(orderDetails.getClient());

        Assert.assertEquals(new Date("12/05/2015"), orderDetails.getDate());

        Assert.assertEquals("laczna cena netto",120 * 1000, orderDetails.getTotalNettoPrice(), 0.01);
        Assert.assertEquals("cena podatku VAT", 8 * orderDetails.getTotalNettoPrice() / 100, orderDetails.getTax(), 0.01);
        Assert.assertEquals("laczna cena brutto", 108 * 120 * 1000 / 100 , orderDetails.getTotalBruttoPrice(), 0.01);

        Assert.assertEquals(ClientResource.getAnnaNowak().getAddress(), orderDetails.getAddress());
        Assert.assertEquals(0.9 * 108 * 120 * 1000 / 100 , orderDetails.calculateNewPriceByPercentDiscount(10), 0.01);
        Assert.assertEquals(108 * 120 * 1000 / 100 - 10*1000 , orderDetails.calculateNewPriceByAmountDiscount(10.0 * 1000), 0.01);
    }

    @Test
    public void OrderWithUsaTaxation() {

        OrderDetails orderDetails = new OrderDetails(
                "12/05/2015", new UsaTaxation(new Country("USA", Currency.USD, 3.73, 10)),
                ClientResource.getPiotrKraus()
        );

        Assert.assertNotNull(orderDetails);

        orderDetails.addAnyBaseProduct(
                new Product("CRM", 100*1000, CategoryResources.getImplementationCategory()),
                new Service("wdrazenie CRM", 20*1000, CategoryResources.getImplementationCategory())
        );

        Assert.assertEquals(2, orderDetails.getContentSize());
        Assert.assertNotNull(orderDetails.getClient());

        Assert.assertEquals(new Date("12/05/2015"), orderDetails.getDate());
        Assert.assertEquals(3, ((UsaTaxation) orderDetails.getTaxation()).getNumberOfTaxedCategories());

        Assert.assertEquals("laczna cena netto",120 * 1000, orderDetails.getTotalNettoPrice(), 0.01);
        Assert.assertEquals("cena podatku VAT", 18 * 1000, orderDetails.getTax(), 0.01);
        Assert.assertEquals("laczna cena brutto", 149999.9, orderDetails.getTotalBruttoPrice(), 0.01);

        Assert.assertEquals(ClientResource.getPiotrKraus().getAddress(), orderDetails.getAddress());
        Assert.assertEquals(orderDetails.getTotalBruttoPrice() * 0.9, orderDetails.calculateNewPriceByPercentDiscount(10), 0.01);
        Assert.assertEquals(orderDetails.getTotalBruttoPrice() - 10*1000, orderDetails.calculateNewPriceByAmountDiscount(10.0 * 1000), 0.01);
    }
}
