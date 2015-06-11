package unitTests.PlacesTests;

import DesignPatternsProject.entities.personalData.Address;
import DesignPatternsProject.entities.places.Restaurant;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by lucjan on 31.03.15.
 */
public class VenueTest {

    @Test
    public void RestaurantTest() {
        Restaurant restaurant = new Restaurant("Casino Royal", new Address("England", "London", "Casino Royal 1/100", "23-290 London"));
        restaurant.addMarks(2, 5, 5, 10);
        Assert.assertEquals(5.5, restaurant.getRate(), 0.01);
    }
}
