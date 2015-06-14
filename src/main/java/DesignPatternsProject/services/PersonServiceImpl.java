package DesignPatternsProject.services;

import DesignPatternsProject.DTO.*;
import DesignPatternsProject.entities.Comunication.Mail;
import DesignPatternsProject.entities.actors.Client;
import DesignPatternsProject.entities.actors.Person;
import DesignPatternsProject.entities.personalData.Role;
import DesignPatternsProject.repositories.MailRepository;
import DesignPatternsProject.repositories.PersonRepository;
import DesignPatternsProject.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucjan on 08.06.15.
 */
@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private MailRepository mailRepository;

    @Override
    public Person loginToSystem(LoginDataDTO loginDataDTO) throws IllegalArgumentException {
        Person person = null;
        try {
            person = personRepository.findByUsernameAndPassword(loginDataDTO.getUsername(), loginDataDTO.getPassword());
        } catch (Exception e) {
            throw new IllegalArgumentException("Cannot login to system");
        }
        return person;
    }

    @Override
    public Person addPerson(PersonFormDTO personFormDTO) {
        return personRepository.save(DTOConverter.toPerson(personFormDTO));
    }

    @Override
    public void deletePerson(long personId) {
        personRepository.delete(personId);
    }

    @Override
    public void deleteAll() {
        personRepository.deleteAll();
    }

    @Override
    public boolean addRoleToPerson(long personId, long roleId) throws IllegalArgumentException{
        Person person = null;
        Role role = null;

        try {
            person = personRepository.findOne(personId);
        }catch (Exception e) {
            throw new IllegalArgumentException("person with id = " + personId + "doesn't exist");
        }

        try {
            role = roleRepository.findOne(roleId);
        }catch (Exception e) {
            throw new IllegalArgumentException("role with id = " + role + "doesn't exist");
        }

        person.addRoles(role);
        personRepository.save(person);
        return true;
    }

    @Override
    public Person getPerson(long personId) throws IllegalArgumentException {
        Person person = null;
        try {
            person = personRepository.findOne(personId);
        } catch (Exception e) {
            throw new IllegalArgumentException("Cannot find person with id = " + personId);
        }
        return person;
    }

    @Override
    public Set<PersonDTOInfo> getAllPersonDtoInfos() {
        Set<PersonDTOInfo> personDTOInfos = new HashSet<>();
        for (Person person : getAllPersons())
            personDTOInfos.add(DTOConverter.toPersonDTOInfo(person));
        return personDTOInfos;
    }

    @Override
    public Set<PersonDTOInfo> getOnlyClients() {
        Set<PersonDTOInfo> onlyClients = new HashSet<>();
        for (Person person : personRepository.findAll())
            if (person instanceof Client)
                onlyClients.add(DTOConverter.toPersonDTOInfo(person));

        return onlyClients;
    }

    @Override
    public Set<PersonDTOInfo> getAllPersonDtoInfosWithoutClients() {
        Set<PersonDTOInfo> onlyPersonsWithoutClients = new HashSet<>();
        for (Person person : personRepository.findAll())
            if (person instanceof Client == false)
                onlyPersonsWithoutClients.add(DTOConverter.toPersonDTOInfo(person));

        return onlyPersonsWithoutClients;
    }

    @Override
    public MailDTOInfo addMail(MailFormDTO mailFormDTO) throws IllegalArgumentException{
        Person personFrom = null;
        Person personTo = null;

        try {
            personFrom = personRepository.findOne(mailFormDTO.getFromId());
        } catch (Exception e) {
            throw new IllegalArgumentException("cannot find person with Id " + mailFormDTO.getFromId());
        }

        try {
            personTo = personRepository.findOne(mailFormDTO.getToId());
        } catch (Exception e) {
            throw new IllegalArgumentException("cannot find person with Id " + mailFormDTO.getToId());
        }

        Mail mail = new Mail(personFrom, personTo, mailFormDTO.getTitle(), mailFormDTO.getMessage(), false);
        personTo.addMail(mail);
        personFrom.addMail(mail);
        Person person = personRepository.save(personFrom);
        personRepository.save(personTo);


        return DTOConverter.toMailDTOInfo(person.findMail(mailFormDTO.getTitle(), mailFormDTO.getMessage()));
    }

    @Override
    public Set<MailDTOInfo> getNotReadedEmails(long personId) throws IllegalArgumentException {
        Set<MailDTOInfo> notReadedEmails = new HashSet<>();

        Person person = null;
        try {
            person = personRepository.findOne(personId);
            for (Mail mail : person.getMailStorage())
                if (mail.getTo().equals(this) && !mail.isReaded())
                    notReadedEmails.add(DTOConverter.toMailDTOInfo(mail));
        } catch (Exception e) {
            throw new IllegalArgumentException("cannot find person with id "+ personId);
        }

        return notReadedEmails;
    }

    @Override
    public Set<MailDTOInfo> getReadedMails(long personId) throws IllegalArgumentException{
        Set<MailDTOInfo> readedEmails = new HashSet<>();

        Person person = null;
        try {
            person = personRepository.findOne(personId);
            for (Mail mail : person.getReadedMails())
                    readedEmails.add(DTOConverter.toMailDTOInfo(mail));
            return readedEmails;
        } catch (Exception e) {
            throw new IllegalArgumentException("cannot find person with id "+ personId);
        }

    }

    @Override
    public MailDTOInfo markMailAsReaded(long personId, long mailId) throws IllegalArgumentException{
        Mail mail = null;
        Person person = null;

        try {
            person = personRepository.findOne(personId);
            mail = mailRepository.findOne(mailId);

            if (person.getMailStorage().contains(mail) && mail.getTo().equals(person)) {
                mail.setReaded(true);
                mail = mailRepository.save(mail);
            }
            MailDTOInfo mailDTOInfo = DTOConverter.toMailDTOInfo(mail);
            return mailDTOInfo;

        } catch (Exception e) {
            throw new IllegalArgumentException("cannot find person " + personId);
        }

    }

    @Override
    public long getNumberOfPersons() {
        return personRepository.count();
    }

    private Set<Person> getAllPersons() {
        Set<Person> personSet = new HashSet<>();
        for (Person person : personRepository.findAll())
            personSet.add(person);
        return personSet;
    }
}
