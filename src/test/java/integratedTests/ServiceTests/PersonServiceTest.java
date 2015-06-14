package integratedTests.ServiceTests;

import DesignPatternsProject.DTO.DTOConverter;
import DesignPatternsProject.DTO.PersonFormDTO;
import DesignPatternsProject.Neo4jTestApplication;
import DesignPatternsProject.entities.actors.*;
import DesignPatternsProject.resources.ClientResource;
import DesignPatternsProject.resources.PersonResource;
import DesignPatternsProject.services.PersonService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

/**
 * Created by lucjan on 14.06.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Neo4jTestApplication.class)
@Transactional
public class PersonServiceTest {

    @Autowired
    private PersonService personService;


    @Test @Rollback(value = true)
    public void insertManager() {
        Person manager = PersonResource.getManagerJanKowalski();
        Assert.assertNotNull(manager);
        Assert.assertTrue(manager instanceof Manager);

        PersonFormDTO personFormDTO = DTOConverter.toPersonFormDTO(manager);
        Assert.assertNotNull(personFormDTO);
        Assert.assertEquals(PersonType.MANAGER , personFormDTO.getPersonType());

        Manager managerDB = (Manager) personService.addPerson(personFormDTO);
        Assert.assertNotNull(manager);
        Assert.assertTrue(managerDB instanceof Manager);
    }

    @Test @Rollback(value = true)
    public void insertStudent() {
        Person student = PersonResource.getDatabaseDeveloperAdrianCiecholewski();
        Assert.assertNotNull(student);
        Assert.assertTrue(student instanceof Student);

        PersonFormDTO personFormDTO = DTOConverter.toPersonFormDTO(student);
        Assert.assertNotNull(personFormDTO);
        Assert.assertEquals(PersonType.STUDENT , personFormDTO.getPersonType());

        Student studentDB = (Student) personService.addPerson(personFormDTO);
        Assert.assertNotNull(student);
        Assert.assertTrue(studentDB instanceof Student);
    }

    @Test @Rollback(value = true)
    public void insertWorker() {
        Person worker = PersonResource.getDatabaseDeveloperAdrianKrawiec();
        Assert.assertNotNull(worker);
        Assert.assertTrue(worker instanceof Worker);

        PersonFormDTO personFormDTO = DTOConverter.toPersonFormDTO(worker);
        Assert.assertNotNull(personFormDTO);
        Assert.assertEquals(PersonType.WORKER , personFormDTO.getPersonType());

        Worker workerDB = (Worker) personService.addPerson(personFormDTO);
        Assert.assertNotNull(worker);
        Assert.assertTrue(workerDB instanceof Worker);
    }


    @Test @Rollback(value = true)
    public void insertClient() {
        Person client = ClientResource.getAnnaNowak();
        Assert.assertNotNull(client);
        Assert.assertTrue(client instanceof Client);

        PersonFormDTO personFormDTO = DTOConverter.toPersonFormDTO(client);
        Assert.assertNotNull(personFormDTO);
        Assert.assertEquals(PersonType.CLIENT , personFormDTO.getPersonType());

        Client clientDB = (Client) personService.addPerson(personFormDTO);
        Assert.assertNotNull(client);
        Assert.assertTrue(clientDB instanceof Client);
    }


    @Test @Rollback(value = true)
    public void BigDeleteTest() {
        personService.deleteAll();  // bo rollback nie dziala


        Random rand = new Random();

        Long [] tabId = new Long[(int) PersonResource.getNumberOfPersons()];

        //  dodajemy wszystkich pracowników
        int i=0;
        for (Person person : PersonResource.getAllPersonsFromResources())
            tabId[i++] = personService.addPerson(DTOConverter.toPersonFormDTO(person)).getId();

        Assert.assertEquals(PersonResource.getNumberOfPersons(), personService.getNumberOfPersons());

        int manyToDelete = rand.nextInt((int) PersonResource.getNumberOfPersons());
        for (int j=0; j<manyToDelete; j++)
            personService.deletePerson(tabId[j]);

//          usuwamy 3 pierwsze person
//        personService.deletePerson(tabId[0]);
//        personService.deletePerson(tabId[1]);
//        personService.deletePerson(tabId[2]);
//
        Assert.assertEquals(PersonResource.getNumberOfPersons() - manyToDelete, personService.getNumberOfPersons());
    }

}
