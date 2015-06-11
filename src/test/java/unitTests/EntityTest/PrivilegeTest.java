package unitTests.EntityTest;

import DesignPatternsProject.entities.personalData.Privilege;
import org.junit.Test;

/**
 * Created by lucjan on 10.06.15.
 */
public class PrivilegeTest {

    @Test
    public void createValidInstance() {
        Privilege privilege = new Privilege("Login To System");
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidInstanceWithNullArgument1() {
        Privilege privilege = new Privilege(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidInstanceWithNullArgument2() {
        Privilege privilege = new Privilege(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidInstanceWithNullArgument3() {
        Privilege privilege = new Privilege(1L, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidInstanceWithNullArgument4() {
        Privilege privilege = new Privilege(new Long(1), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidInstanceWithNullArgument5() {
        Privilege privilege = new Privilege(null, "Login to system");
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidInstanceWithWrongStringArgument1() {
        Privilege privilege = new Privilege(null, "Logi9");
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidInstanceWithWrongStringArgument2() {
        Privilege privilege = new Privilege(null, "Logi&");
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidInstanceWithWrongStringArgument3() {
        Privilege privilege = new Privilege(null, "9");
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidInstanceWithWrongStringArgument4() {
        Privilege privilege = new Privilege(null, "");
    }


}
