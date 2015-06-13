package DesignPatternsProject.services;

import DesignPatternsProject.DTO.LoginDataDTO;
import DesignPatternsProject.DTO.PersonDTOInfo;
import DesignPatternsProject.DTO.PersonFormDTO;
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
//    boolean addMail()
}
