package DesignPatternsProject.services;

import DesignPatternsProject.DTO.*;
import DesignPatternsProject.entities.actors.Person;

import java.util.Set;

/**
 * Created by lucjan on 08.06.15.
 */
public interface PersonService {
    Person loginToSystem(LoginDataDTO loginDataDTO) throws IllegalArgumentException;
    Person addPerson(PersonFormDTO personFormDTO);
    void deletePerson(long personId);
    boolean addRoleToPerson(long personId, long roleId) throws IllegalArgumentException;
    Person getPerson(long personId) throws IllegalArgumentException;
    Set<PersonDTOInfo> getAllPersonDtoInfos();
    Set<PersonDTOInfo> getOnlyClients();
    Set<PersonDTOInfo> getAllPersonDtoInfosWithoutClients();
    MailDTOInfo addMail(MailFormDTO mailFormDTO) throws IllegalArgumentException;
    Set<MailDTOInfo> getNotReadedEmails(long personId) throws IllegalArgumentException;
    Set<MailDTOInfo> getReadedMails(long personId) throws IllegalArgumentException;
    MailDTOInfo markMailAsReaded(long personId, long mailId);
}
