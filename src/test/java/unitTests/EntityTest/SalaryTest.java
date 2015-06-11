package unitTests.EntityTest;

import DesignPatternsProject.entities.personalData.EmploymentContractType;
import DesignPatternsProject.entities.personalData.Salary;
import org.junit.Test;

/**
 * Created by lucjan on 11.06.15.
 */
public class SalaryTest {

    @Test
    public void SalaryInstance1() {
        new Salary(EmploymentContractType.FIXED_TERM_EMPLOYMENT, 2200);
    }

    @Test
    public void SalaryInstance2() {
        new Salary(EmploymentContractType.REGULAR_EMPLOYMENT, 2200);
    }

    @Test(expected = IllegalArgumentException.class)
    public void SalaryInstanceWithNullArgument() {
        new Salary(null, 40000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void SalaryInstanceWithInvalidArgument1() {
        new Salary(null, 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void SalaryInstanceWithInvalidArgument2() {
        new Salary(null, -100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void SalaryInstanceWithInvalidArgument3() {
        new Salary(null, 0);
    }
}
