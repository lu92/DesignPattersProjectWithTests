package unitTests;

import DesignPatternsProject.entities.actors.Manager;
import DesignPatternsProject.entities.actors.PersonType;
import DesignPatternsProject.factories.FactoryProducer;
import DesignPatternsProject.factories.FactoryType;
import DesignPatternsProject.factories.PersonFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lucjan on 29.04.15.
 */
public class FactoryProducerTest {

    @Test
    public void instancesTest() {
        Assert.assertNotNull(FactoryProducer.getFactory(FactoryType.PERSON_FACTORY));
        Assert.assertNotNull(FactoryProducer.getFactory(FactoryType.VENUE_FACTORY));
    }

    public  void PersonFactoryTest() {
        PersonFactory personFactory = (PersonFactory) FactoryProducer.getFactory(FactoryType.PERSON_FACTORY);
        Assert.assertNotNull(personFactory);

        Manager manager = (Manager) personFactory.createPerson(PersonType.MANAGER);

        Assert.assertNotNull(manager.getAddress());
        Assert.assertNotNull(manager.getPersonality());
        Assert.assertNotNull(manager.getRoleStorage());
    }
}
