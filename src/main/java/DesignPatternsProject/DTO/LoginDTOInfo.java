package DesignPatternsProject.DTO;

import DesignPatternsProject.entities.actors.PersonType;

/**
 * Created by lucjan on 15.06.15.
 */
public class LoginDTOInfo {
    private Long id;
    private PersonType personType;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
