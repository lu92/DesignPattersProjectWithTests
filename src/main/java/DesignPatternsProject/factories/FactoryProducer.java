package DesignPatternsProject.factories;

/**
 * Created by lucjan on 29.04.15.
 */
public class FactoryProducer {

    private final static PersonFactory personFactory = new PersonFactory();
    private final static VenueFactory placeFactory = new VenueFactory();

    private FactoryProducer() {
    }

    public static AbstractFactory getFactory(FactoryType factoryType) {
       switch (factoryType) {
           case PERSON_FACTORY:
               return personFactory;

           case VENUE_FACTORY:
               return placeFactory;

           default:
               return null;
       }
    }
}
