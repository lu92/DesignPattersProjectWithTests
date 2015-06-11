package unitTests.EntityTest;

import DesignPatternsProject.entities.personalData.Privilege;
import DesignPatternsProject.entities.personalData.Role;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lucjan on 10.06.15.
 */
public class RoleTest {
    @Test
    public void createValidInstance() {
        Role role = new Role("Developer Role");
    }

    @Test
    public void createValidInstanceWithPrivileges() {
        Role role = new Role("Developer Role");
        role.addPrivileges(
                new Privilege("creating tests"),
                new Privilege("creating raports"),
                new Privilege("creating code"));
        Assert.assertEquals(3, role.getPrivilegeStorage().size());
    }



    @Test(expected = IllegalArgumentException.class)
    public void tryAddNullParameter() {
        Role role = new Role("Developer Role");
        role.addPrivileges(
                new Privilege("creating tests"), null
        );
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidInstanceWithNullArgument1() {
        Role role = new Role(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidInstanceWithNullArgument2() {
        Role role = new Role(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidInstanceWithNullArgument3() {
        Role role = new Role(1L, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidInstanceWithNullArgument4() {
        Role role = new Role(new Long(1), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidInstanceWithNullArgument5() {
        Role role = new Role(null, "Developer");
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidInstanceWithWrongStringArgument1() {
        Role role = new Role(null, "Logi9");
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidInstanceWithWrongStringArgument2() {
        Role role = new Role(null, "Logi&");
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidInstanceWithWrongStringArgument3() {
        Role role = new Role(null, "9");
    }

    @Test(expected = IllegalArgumentException.class)
    public void createInvalidInstanceWithWrongStringArgument4() {
        Role role = new Role(null, "");
    }
}
