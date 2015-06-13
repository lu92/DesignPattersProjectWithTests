package integratedTests;

import DesignPatternsProject.DTO.MailFormDTO;
import DesignPatternsProject.Neo4jTestApplication;
import DesignPatternsProject.entities.Comunication.Mail;
import DesignPatternsProject.entities.actors.Person;
import DesignPatternsProject.repositories.MailRepository;
import DesignPatternsProject.repositories.PersonRepository;
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

import java.util.Set;

/**
 * Created by lucjan on 13.06.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Neo4jTestApplication.class)
@Transactional
public class MailTest {

    @Autowired
    private MailRepository mailRepository;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    @Test @Rollback(value = true)
    public void setMailBetweenTwoPersons() {
        long personFromId = personRepository.save(PersonResource.getJavaDeveloperWojciechSeliga()).getId();
        long personToId = personRepository.save(PersonResource.getManagerJanKowalski()).getId();

        MailFormDTO mailFromDTO = new MailFormDTO(personFromId, personToId, "mail title", "mail message");
        personService.addMail(mailFromDTO);

        Assert.assertEquals(1, mailRepository.count());


        Person personTo = personRepository.findOne(personToId);
        Person personFrom = personRepository.findOne(personToId);

        Assert.assertTrue(isExists(mailFromDTO.getTitle(), mailFromDTO.getMessage(), personTo.getMailStorage()));
        Assert.assertTrue(isExists(mailFromDTO.getTitle(), mailFromDTO.getMessage(), personFrom.getMailStorage()));

        Assert.assertEquals(1,personFrom.getMailStorage().size());
        Assert.assertEquals(1, personTo.getMailStorage().size());
    }

    private boolean isExists(String mailTitle, String mailMessage, Set<Mail> mailSet) {
        if (mailSet != null) {
            for (Mail mail : mailSet) {
                if (mail.getTitle().equals(mailTitle) && mail.getMessage().equals(mailMessage))
                    return true;
            }
        }
        return false;
    }

}
