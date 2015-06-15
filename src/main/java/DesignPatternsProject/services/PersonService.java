package DesignPatternsProject.services;

import DesignPatternsProject.DTO.*;
import DesignPatternsProject.entities.actors.Client;
import DesignPatternsProject.entities.actors.Person;

import java.util.Set;

/**
 * Created by lucjan on 08.06.15.
 */
public interface PersonService {
    Person loginToSystem(LoginDataDTO loginDataDTO) throws IllegalArgumentException;
    Person addPerson(PersonFormDTO personFormDTO);
    Client addClient(ClientFormDTO clientFormDTO);
    void deletePerson(long personId);
    void deleteAll();
    boolean addRoleToPerson(long personId, long roleId) throws IllegalArgumentException;
    Person getPerson(long personId) throws IllegalArgumentException;
    Set<PersonDTOInfo> getAllPersonDtoInfos();
    Set<PersonDTOInfo> getOnlyClients();
    Set<PersonDTOInfo> getAllPersonDtoInfosWithoutClients();
    MailDTOInfo addMail(MailFormDTO mailFormDTO) throws IllegalArgumentException;
    Set<MailDTOInfo> getNotReadedEmails(long personId) throws IllegalArgumentException;
    Set<MailDTOInfo> getReadedMails(long personId) throws IllegalArgumentException;
    MailDTOInfo markMailAsReaded(long personId, long mailId);
    long getNumberOfPersons();
}
