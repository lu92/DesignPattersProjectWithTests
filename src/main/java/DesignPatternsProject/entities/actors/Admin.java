package DesignPatternsProject.entities.actors;

import DesignPatternsProject.entities.personalData.Address;
import DesignPatternsProject.entities.personalData.Personality;
import DesignPatternsProject.entities.personalData.Salary;

/**
 * Created by lucjan on 15.06.15.
 */
public class Admin extends Person {
    public Admin(String username, String password, String email) throws IllegalArgumentException {
        super(username, password, email);
    }
    public Admin(){
    }
}
