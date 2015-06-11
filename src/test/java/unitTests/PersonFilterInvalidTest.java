package unitTests;

import DesignPatternsProject.filters.personFilters.AddressCriteria;
import DesignPatternsProject.resources.PersonResource;
import org.junit.Test;

/**
 * Created by lucjan on 10.06.15.
 */
public class PersonFilterInvalidTest {
    //  testing the invalid parameter of constructors


    @Test(expected = IllegalArgumentException.class)
    public void AddressCriteriaWithNullArgument1() {
        new AddressCriteria(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void AddressCriteriaWithNullArgument2() {
        new AddressCriteria(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void AddressCriteriaWithNullArgument3() {
        new AddressCriteria(null, PersonResource.getDatabaseDeveloperAdrianKrawiec().getAddress());
    }

    @Test(expected = IllegalArgumentException.class)
    public void AddressCriteriaWithNullArgument4() {
        new AddressCriteria(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void AddressCriteriaWithNullArgument5() {
        new AddressCriteria(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void AddressCriteriaWithNullArgument6() {
        new AddressCriteria(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void AddressCriteriaWithNullArgument7() {
        new AddressCriteria(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void AddressCriteriaWithNullArgument8() {
        new AddressCriteria(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void AddressCriteriaWithNullArgument9() {
        new AddressCriteria(null);
    }

}
