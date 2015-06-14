package integratedTests.ServiceTests;

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
public class SendingAndReceivingMails {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonService personService;

    @Autowired
    private MailRepository mailRepository;

    @Test @Rollback(value = true)
    public void sendingAndReceivingMails() {
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

        Mail mail = personFrom.findMail("mail title", "mail message");
        Assert.assertNotNull(mail);

//        Set<Mail> mailSet = mailRepository.findByTitleAndMessage("mail title", "mail message");
//        Assert.assertEquals(1, mailSet.size());

        Assert.assertEquals(0, personService.getReadedMails(personFrom.getId()).size());
        Assert.assertEquals(0, personService.getReadedMails(personTo.getId()).size());


        personService.markMailAsReaded(personTo.getId(), mail.getId());
        personFrom = personRepository.findOne(personFromId);
        Assert.assertEquals(0, personService.getReadedMails(personFrom.getId()).size());
        Assert.assertEquals(1, personService.getReadedMails(personTo.getId()).size());



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
