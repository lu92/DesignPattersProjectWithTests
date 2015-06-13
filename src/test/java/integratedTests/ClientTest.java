package integratedTests;

import DesignPatternsProject.Neo4jTestApplication;
import DesignPatternsProject.entities.actors.Client;
import DesignPatternsProject.repositories.ClientRepository;
import DesignPatternsProject.resources.ClientResource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lucjan on 12.06.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Neo4jTestApplication.class)
@Transactional
public class ClientTest {

    @Autowired
    private ClientRepository clientRepository;

    @Test @Rollback(true)
    public void saveClient() {

//        clientRepository.deleteAll();
//        System.out.println(ClientResource.getAnnaNowak());
//
//        clientRepository.save(ClientResource.getAnnaNowak());
//        Assert.assertEquals(1, clientRepository.count());
    }

}
