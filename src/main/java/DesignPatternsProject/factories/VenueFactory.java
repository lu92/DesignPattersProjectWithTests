package DesignPatternsProject.factories;

import DesignPatternsProject.entities.actors.Person;
import DesignPatternsProject.entities.actors.PersonType;
import DesignPatternsProject.entities.places.*;

/**
 * Created by lucjan on 10.03.15.
 */
public class VenueFactory extends AbstractFactory {

    private static VenueFactory instance = new VenueFactory();

    public VenueFactory() {
    }

//    @Override
//    public AbstractFactory getInstance() {
//        return instance;
//    }

    @Override
    public Person createPerson(PersonType type) {
        return null;
    }

    @Override
    public Venue createVenue(VenueType type) {

        Venue venue = null;

        switch (type) {
            case COFFEE_HOUSE:
                venue = new CoffeeHouse();
                break;

            case OFFICE:
                venue = new Office();
                break;

            case RESTAURANT:
                venue = new Restaurant();
                break;
        }
        return venue;
    }
}
