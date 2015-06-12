package integratedTests;

import DesignPatternsProject.repositories.*;
import DesignPatternsProject.resources.PersonResource;
import DesignPatternsProject.Neo4jTestApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lucjan on 08.06.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Neo4jTestApplication.class)
@Transactional
public class PersonTest {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PrivilegeRepository privilegeRepository;

    @Autowired
    private SalaryRepository salaryRepository;

    @Test @Rollback(true)
    public void saveSinglePerson() {
        Assert.assertNotNull(personRepository);
        clearDatabase();
        personRepository.save(PersonResource.getJavaDeveloperWojciechSeliga());
        Assert.assertEquals(1, personRepository.count());
        Assert.assertEquals(1, addressRepository.count());
        Assert.assertEquals(2, roleRepository.count());
        Assert.assertEquals(6, privilegeRepository.count());
        Assert.assertEquals(1, salaryRepository.count());
    }

    @Test @Rollback(true)
    public void saveTwoPersons() {
        Assert.assertNotNull(personRepository);
        clearDatabase();
        personRepository.save(PersonResource.getJavaDeveloperWojciechSeliga());
        personRepository.save(PersonResource.getJavaDeveloperPiotrNawalka());

        Assert.assertEquals(2, personRepository.count());
        Assert.assertEquals(2, addressRepository.count());
        Assert.assertEquals(2, roleRepository.count());
        Assert.assertEquals(6, privilegeRepository.count());
        Assert.assertEquals(2, salaryRepository.count());
    }

    private void clearDatabase() {
        personRepository.deleteAll();
        addressRepository.deleteAll();
        roleRepository.deleteAll();
        privilegeRepository.deleteAll();
        salaryRepository.deleteAll();
    }
}
