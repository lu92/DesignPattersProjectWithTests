package DesignPatternsProject.controllers;

import DesignPatternsProject.DTO.PersonDTOInfo;
import DesignPatternsProject.DTO.PersonFormDTO;
import DesignPatternsProject.DTO.SingleArgumentDTO;
import DesignPatternsProject.entities.actors.Person;
import DesignPatternsProject.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by lucjan on 13.06.15.
 */

@RestController
@RequestMapping(value = "/person")
public class PersonController {


    @Autowired
    private PersonService personService;

    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Person createPerson(@RequestBody PersonFormDTO personFormDTO) {
        return personService.addPerson(personFormDTO);
    }

    @ResponseBody
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public Set<PersonDTOInfo> getAllPersons() {
        return personService.getAllPersonDtoInfosWithoutClients();
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public Set<PersonDTOInfo> deletePerson(@RequestBody SingleArgumentDTO singleArgumentDTO) {
        personService.deletePerson(singleArgumentDTO.getValue());
        return personService.getAllPersonDtoInfos();
    }

}
