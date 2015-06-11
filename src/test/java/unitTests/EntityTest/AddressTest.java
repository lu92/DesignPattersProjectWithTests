package unitTests.EntityTest;

import DesignPatternsProject.entities.personalData.Address;
import org.junit.Test;

/**
 * Created by lucjan on 10.06.15.
 */
public class AddressTest {

    @Test
    public void createValidInstance() {
        Address address = new Address("England", "London", "Casino Royal 1/100", "12-990 London");
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidInstanceWithNullArgument1() {
        Address address = new Address(null, "London", "Casino Royal 1/100", "12-990 London");
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidInstanceWithNullArgument2() {
        Address address = new Address("England", null, "Casino Royal 1/100", "12-990 London");
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidInstanceWithNullArgument3() {
        Address address = new Address("England", "London", null, "12-990 London");
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidInstanceWithNullArgument4() {
        Address address = new Address("England", "London", "Casino Royal 1/100", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidInstanceWithStringEmptyArgument1() {
        Address address = new Address("", "London", "Casino Royal 1/100", "12-990 London");
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidInstanceWithStringEmptyArgument2() {
        Address address = new Address("England", "", "Casino Royal 1/100", "12-990 London");
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidInstanceWithStringEmptyArgument3() {
        Address address = new Address("England", "London", "", "12-990 London");
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidInstanceWithStringEmptyArgument4() {
        Address address = new Address("England", "London", "Casino Royal 1/100", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidInstanceWithWrongZipCodeArgument1() {
        Address address = new Address("England", "London", "Casino Royal 1/100", "12232-399 London");
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidInstanceWithWrongZipCodeArgument2() {
        Address address = new Address("England", "London", "Casino Royal 1/100", "London");
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidInstanceWithWrongZipCodeArgument3() {
        Address address = new Address("England", "London", "Casino Royal 1/100", "23 London");
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidInstanceWithWrongZipCodeArgument4() {
        Address address = new Address("England", "London", "Casino Royal 1/100", "1-1London");
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidInstanceWithWrongZipCodeArgument5() {
        Address address = new Address("England", "London", "Casino Royal 1/100", "1-1 London");
    }
}
