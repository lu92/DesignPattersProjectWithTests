package DesignPatternsProject.builders;

import DesignPatternsProject.entities.actors.Client;
import DesignPatternsProject.entities.actors.Manager;
import DesignPatternsProject.entities.actors.Student;
import DesignPatternsProject.entities.actors.Worker;

/**
 * Created by lucjan on 13.06.15.
 */
public class ClientBuilder extends PersonBuilder {


    public ClientBuilder(String username, String password, String email, Class clazz) throws IllegalArgumentException {
        super(username, password, email, clazz);
    }

    public ClientBuilder(String username, String password, String email, String accountNumber, String PIN, Class clazz) throws IllegalArgumentException {
        super(username, password, email, clazz);
    }

    protected void preparePersonFromStringType(String username, String password, String email, String type) {
        String properTypeVales [] = {"client", "consultant", "manager", "student", "worker"};
        Class PersonsTypes [] = {Client.class, Manager.class, Student.class, Worker.class };

        int n = 0;

        for (int i=0; i<properTypeVales.length; i++) {
            if (properTypeVales[i].equalsIgnoreCase(type)) {
                preparePersonFromClassType(username, password, email, PersonsTypes[i]);
            }
            else n++;
        }

        if (n == properTypeVales.length)
            throw new IllegalArgumentException("constructor cannot set invalid name of Person Object");
    }
}
