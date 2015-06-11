package unitTests;

import DesignPatternsProject.entities.orders.AbstractOrderDetails;
import DesignPatternsProject.entities.orders.OrderDetails;
import DesignPatternsProject.resources.BaseProductResource;
import DesignPatternsProject.resources.ClientResource;
import DesignPatternsProject.resources.CountryResources;
import DesignPatternsProject.strategies.discounts.DiscountHandler;
import DesignPatternsProject.strategies.discounts.FreeConsulting;
import DesignPatternsProject.strategies.discounts.Rebate;
import DesignPatternsProject.strategies.discounts.RightLoyalty;
import DesignPatternsProject.strategies.taxations.PolishTaxation08;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by lucjan on 10.06.15.
 */
public class DiscountTests {

    private AbstractOrderDetails orderDetails;

    @Before
    public void init() {
        orderDetails = new OrderDetails(
                "12/05/2015", new PolishTaxation08(CountryResources.getPoland()),
                ClientResource.getAnnaNowak());
    }

    @Test   //  pokrywa RD1 RD3 RD9
    public void PT1() {
        orderDetails.addAnyBaseProduct(
                BaseProductResource.getAlgorithmLibrary(), BaseProductResource.getCRM(), BaseProductResource.getERP(),
                BaseProductResource.getMultiThreadingAlgorithmLibrary(), BaseProductResource.getSystemSecure());
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

    @Test   //  pokrywa RD2 RD4 RD10
    public void PT2() {
        orderDetails.addAnyBaseProduct(
                BaseProductResource.getAlgorithmLibrary(), BaseProductResource.getCRM(), BaseProductResource.getERP(),
                BaseProductResource.getMultiThreadingAlgorithmLibrary());
        Assert.assertTrue(orderDetails.getTotalBruttoPrice() > 100 * 1000);
        Assert.assertTrue(orderDetails.getTotalBruttoPrice() > 300 * 1000);
        Assert.assertFalse(orderDetails.getTotalBruttoPrice() > 2 * 1000 * 1000);

        DiscountHandler discountHandler = new DiscountHandler(orderDetails);
        discountHandler.addDiscountCondition(
                new Rebate(100* 1000, 1.5), new FreeConsulting(300 * 1000), new RightLoyalty());
        Assert.assertNotNull(discountHandler);

        Assert.assertTrue(discountHandler.getDiscountNotification().isGrantedRebate());
        Assert.assertTrue(discountHandler.getDiscountNotification().isGrantedFreeConsulting());
        Assert.assertFalse(discountHandler.getDiscountNotification().isGrantedRightLoyalty());
    }

    @Test   //  pokrywa RD6 RD8 RD14
    public void PT3() {
        orderDetails.addAnyBaseProduct(
                BaseProductResource.getCRM());
        Assert.assertTrue(orderDetails.getTotalBruttoPrice() > 100 * 1000);
        Assert.assertFalse(orderDetails.getTotalBruttoPrice() > 300 * 1000);
        Assert.assertFalse(orderDetails.getTotalBruttoPrice() > 2 * 1000 * 1000);

        DiscountHandler discountHandler = new DiscountHandler(orderDetails);
        discountHandler.addDiscountCondition(
                new Rebate(100* 1000, 1.5), new FreeConsulting(300 * 1000), new RightLoyalty());
        Assert.assertNotNull(discountHandler);

        Assert.assertTrue(discountHandler.getDiscountNotification().isGrantedRebate());
        Assert.assertFalse(discountHandler.getDiscountNotification().isGrantedFreeConsulting());
        Assert.assertFalse(discountHandler.getDiscountNotification().isGrantedRightLoyalty());
    }

    @Test   //  pokrywa RD16
    public void PT4() {
        orderDetails.addAnyBaseProduct(
                BaseProductResource.getConsulting());
        Assert.assertFalse(orderDetails.getTotalBruttoPrice() > 100 * 1000);
        Assert.assertFalse(orderDetails.getTotalBruttoPrice() > 300 * 1000);
        Assert.assertFalse(orderDetails.getTotalBruttoPrice() > 2 * 1000 * 1000);

        DiscountHandler discountHandler = new DiscountHandler(orderDetails);
        discountHandler.addDiscountCondition(
                new Rebate(100* 1000, 1.5), new FreeConsulting(300 * 1000), new RightLoyalty());
        Assert.assertNotNull(discountHandler);

        Assert.assertFalse(discountHandler.getDiscountNotification().isGrantedRebate());
        Assert.assertFalse(discountHandler.getDiscountNotification().isGrantedFreeConsulting());
        Assert.assertFalse(discountHandler.getDiscountNotification().isGrantedRightLoyalty());
    }
}
