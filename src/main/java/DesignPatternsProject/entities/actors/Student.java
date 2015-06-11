package DesignPatternsProject.entities.actors;

import DesignPatternsProject.entities.personalData.Salary;

/**
 * Created by lucjan on 10.03.15.
 */
public class Student extends Person {
    Salary salary;

    public Student(String username, String password, String email) {
        super(username, password, email);
    }

    public Student() {

    }
}
