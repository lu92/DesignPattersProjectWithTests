package DesignPatternsProject.builders;

import DesignPatternsProject.entities.actors.Manager;
import DesignPatternsProject.entities.personalData.Address;
import DesignPatternsProject.entities.personalData.Personality;
import DesignPatternsProject.entities.personalData.Role;
import DesignPatternsProject.entities.personalData.Salary;

/**
 * Created by lucjan on 31.03.15.
 */
public class ManagerBuilder extends PersonBuilder {
    public ManagerBuilder(String username, String password, String email) throws IllegalArgumentException {
        super(username, password, email, Manager.class);
    }

    public ManagerBuilder(String username, String password, String email, Personality personality, Role role, Address address) throws IllegalArgumentException {
        super(username, password, email, Manager.class, personality, role, address);
    }

    public void setSalary(Salary salary) {
        ((Manager) this.person).setSalary(salary);
    }

    public Salary getSalary() {
        return ((Manager) this.person).getSalary();
    }

}
