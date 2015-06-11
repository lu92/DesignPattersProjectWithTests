package DesignPatternsProject.factories;

import DesignPatternsProject.entities.actors.*;
import DesignPatternsProject.entities.personalData.Address;
import DesignPatternsProject.entities.personalData.Personality;
import DesignPatternsProject.entities.personalData.Role;
import DesignPatternsProject.entities.places.Venue;
import DesignPatternsProject.entities.places.VenueType;

/**
 * Created by lucjan on 10.03.15.
 */
public class PersonFactory extends AbstractFactory {

    private static  PersonFactory instance = new PersonFactory();

    public PersonFactory() {
    }


//    @Override
//    public AbstractFactory getInstance() {
//        return instance;
//    }

    public Person createPerson(PersonType type) {

        Person personObject = null;

        switch (type) {
            case CLIENT :
                personObject = new Client();
                createInstances(personObject);
                break;
            case CONSULTANT :
                personObject = new Consultant();
                createInstances(personObject);
                break;

            case MANAGER :
                personObject = new Manager();
                createInstances(personObject);
                break;

            case STUDENT :
                personObject = new Student();
                createInstances(personObject);
                break;

            case WORKER :
                personObject = new Worker();
                createInstances(personObject);
                break;
        }
        return personObject;
    }


    private void createInstances(Person personObject) {
        personObject.addRoles(new Role());
        personObject.setAddress(new Address());
        personObject.setPersonality(new Personality());
    }

    @Override
    public Venue createVenue(VenueType type) {
        return null;
    }
}
