package DesignPatternsProject.controllers;

import DesignPatternsProject.DTO.*;
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
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public PersonDTOInfo login(@RequestBody LoginDataDTO loginDataDTO) {
        return null;
    }

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
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Set<PersonDTOInfo> deletePerson(@RequestBody SingleArgumentDTO singleArgumentDTO) {
        personService.deletePerson(singleArgumentDTO.getValue());
        return personService.getAllPersonDtoInfos();
    }

    @ResponseBody
    @RequestMapping(value = "/addMail", method = RequestMethod.POST)
    public void addMail(@RequestBody MailFormDTO mailFormDTO) {
        personService.addMail(mailFormDTO);
    }


    @ResponseBody
    @RequestMapping(value = "/getNotReadedMails", method = RequestMethod.POST)
    public Set<MailDTOInfo> getNotReaderMails(@RequestBody SingleArgumentDTO singleArgumentDTO) {
        return personService.getNotReadedEmails(singleArgumentDTO.getValue());
    }

    @ResponseBody
    @RequestMapping(value = "/getReadedMails", method = RequestMethod.POST)
    public Set<MailDTOInfo> getReaderMails(@RequestBody SingleArgumentDTO singleArgumentDTO) {
        return personService.getReadedMails(singleArgumentDTO.getValue());
    }

    @ResponseBody
    @RequestMapping(value = "/markMailAsReaded", method = RequestMethod.POST)
    public MailDTOInfo markMailAsReaded(@RequestBody DoubleArgumentDTO doubleArgumentDTO) {
        return personService.markMailAsReaded(doubleArgumentDTO.getFirstArgument(), doubleArgumentDTO.getSecondArgument());
    }

}
