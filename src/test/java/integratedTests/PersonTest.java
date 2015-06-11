package integratedTests;

import DesignPatternsProject.repositories.AddressRepository;
import DesignPatternsProject.repositories.PersonRepository;
import DesignPatternsProject.repositories.RoleRepository;
import DesignPatternsProject.resources.PersonResource;
import DesignPatternsProject.repositories.PrivilegeRepository;
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

    @Test @Rollback(true)
    public void savePerson() {
        Assert.assertNotNull(personRepository);
        personRepository.save(PersonResource.getJavaDeveloperWojciechSeliga());
        Assert.assertEquals(1, personRepository.count());
        Assert.assertEquals(1, addressRepository.count());
        Assert.assertEquals(2, roleRepository.count());
        Assert.assertEquals(6, privilegeRepository.count());
    }

}
