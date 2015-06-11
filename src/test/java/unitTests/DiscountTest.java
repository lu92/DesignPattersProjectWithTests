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
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * Created by lucjan on 09.06.15.
 */
public class DiscountTest {

    @BeforeClass
    public static void initOrderAndCalculateDiscount() {
    }

    @Test
    public void test() {
        AbstractOrderDetails orderDetails = new OrderDetails(
                "12/05/2015", new PolishTaxation08(CountryResources.getPoland()),
                ClientResource.getAnnaNowak());
        Assert.assertNotNull(orderDetails);


        orderDetails.addAnyBaseProduct(
                BaseProductResource.getAlgorithmLibrary(), BaseProductResource.getCRM(), BaseProductResource.getERP());

        Assert.assertEquals((300 + 120 + 200) * 1000 ,orderDetails.getTotalNettoPrice(), 0.01);
        Assert.assertEquals(620000 + 49600, orderDetails.getTotalBruttoPrice(), 0.01);

        DiscountHandler discountHandler = new DiscountHandler(orderDetails);
        Assert.assertNotNull(discountHandler);

        discountHandler.addDiscountCondition(
                new Rebate(100* 1000, 1.5), new RightLoyalty(), new FreeConsulting(300 * 1000));
        Assert.assertEquals(3, discountHandler.getNumberOfDiscountConditions());



        Assert.assertTrue(discountHandler.getDiscountNotification().isGrantedRebate());
        Assert.assertEquals(10044.0, discountHandler.getDiscountNotification().getRebate(), 0.01);
        Assert.assertTrue(discountHandler.getDiscountNotification().isGrantedFreeConsulting());
        Assert.assertFalse(discountHandler.getDiscountNotification().isGrantedRightLoyalty());
        System.out.println("discount info " + discountHandler.getDiscountNotification());
    }
}
