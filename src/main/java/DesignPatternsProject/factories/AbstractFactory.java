package DesignPatternsProject.factories;

import DesignPatternsProject.entities.actors.Person;
import DesignPatternsProject.entities.actors.PersonType;
import DesignPatternsProject.entities.places.Venue;
import DesignPatternsProject.entities.places.VenueType;

/**
 * Created by lucjan on 29.04.15.
 */
public abstract class AbstractFactory {
//    public abstract AbstractFactory getInstance();
    public abstract Person createPerson(PersonType type);
    public abstract Venue createVenue(VenueType type);
}
