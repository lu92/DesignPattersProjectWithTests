package DesignPatternsProject.filters.personFilters;

import DesignPatternsProject.entities.actors.Person;
import DesignPatternsProject.filters.PersonCriteria;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucjan on 04.06.15.
 */
public class NameAndLastNameCriteria extends PersonCriteria {

    private String nameCriteria;
    private String lastnameCriteria;

    public NameAndLastNameCriteria(String nameCriteria, String lastnameCriteria) {
        if (nameCriteria == null || lastnameCriteria == null)
            throw new IllegalArgumentException("detect one or many null parameter pointers");
        else if (nameCriteria.isEmpty() || lastnameCriteria.isEmpty())
            throw new IllegalArgumentException("one or many parameter is empty");
        else if (nameCriteria.contains(".*\\d.*") || lastnameCriteria.contains(".*\\d.*"))
            throw new IllegalArgumentException("one or many parameter contain digit number");
        else {
            this.nameCriteria = nameCriteria;
            this.lastnameCriteria = lastnameCriteria;
        }
    }

    public NameAndLastNameCriteria(PersonCriteria next, String nameCriteria, String lastnameCriteria) throws IllegalArgumentException {
        this(nameCriteria, lastnameCriteria);
        if (next == null)
            throw new IllegalArgumentException("detect one or many null parameter pointers");
        else
            setNext(next);

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
