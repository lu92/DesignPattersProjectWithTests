package DesignPatternsProject.entities.actors;

import DesignPatternsProject.entities.personalData.Salary;

/**
 * Created by lucjan on 10.03.15.
 */
public class Consultant extends Person{
    Salary salary;

    public Consultant(String username, String password, String email) {
        super(username, password, email);
    }

    public Consultant() {

    }
}
