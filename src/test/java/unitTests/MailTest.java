package unitTests;

import DesignPatternsProject.entities.Comunication.Mail;
import DesignPatternsProject.entities.actors.Person;
import DesignPatternsProject.resources.PersonResource;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by lucjan on 14.06.15.
 */
public class MailTest {

    @Test
    public void mailTest() {
        Person personFROM = PersonResource.getDatabaseDeveloperAdrianKrawiec();
        Person personTo = PersonResource.getJavaDeveloperWojciechSeliga();

        Mail mail = new Mail(personFROM, personTo, "mail title", "mail message", false);

        personFROM.addMail(mail);
        personTo.addMail(mail);

        Assert.assertEquals(1, personFROM.getMailStorage().size());
        Assert.assertEquals(1, personTo.getMailStorage().size());

        Assert.assertNotNull(personFROM.findMail("mail title", "mail message"));
        Assert.assertNotNull(personFROM.findMail("mail title", "mail message"));

        Assert.assertEquals(0, personFROM.getReadedMails().size());
        Assert.assertEquals(0, personTo.getReadedMails().size());

        mail.setReaded(true);

        Assert.assertEquals(0, personFROM.getReadedMails().size());
        Assert.assertEquals(1, personTo.getReadedMails().size());


    }

}
