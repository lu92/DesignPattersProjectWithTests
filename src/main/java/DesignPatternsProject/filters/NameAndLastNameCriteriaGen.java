package DesignPatternsProject.filters;


import DesignPatternsProject.entities.actors.Person;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucjan on 04.06.15.
 */
public class NameAndLastNameCriteriaGen extends ObjectCriteria<Person> {

    private String nameCriteria;
    private String lastnameCriteria;



    public NameAndLastNameCriteriaGen(String nameCriteria, String lastnameCriteria) {
        this.nameCriteria = nameCriteria;
        this.lastnameCriteria = lastnameCriteria;
    }

    public NameAndLastNameCriteriaGen(ObjectCriteria next, String nameCriteria, String lastnameCriteria) {
        super(next);
        this.nameCriteria = nameCriteria;
        this.lastnameCriteria = lastnameCriteria;
    }

    @Override
    public Set<Person> performFilter(Set<Person> allPersons) {
        Set<Person> personFindedByNameAndLastname = new HashSet<>();
        for (Person person : allPersons) {
            if (person.getPersonality().getName().equals(nameCriteria) &&
                    person.getPersonality().getLastname().equals(lastnameCriteria))
                personFindedByNameAndLastname.add(person);
        }
        return personFindedByNameAndLastname;
    }

    @Override
    public String toString() {
        return "NameAndLastNameCriteria{" +
                "nameCriteria='" + nameCriteria + '\'' +
                ", lastnameCriteria='" + lastnameCriteria + '\'' +
                "} " + super.toString();
    }
}
