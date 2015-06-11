package DesignPatternsProject.filters.personFilters;

import DesignPatternsProject.entities.actors.Person;
import DesignPatternsProject.filters.PersonCriteria;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucjan on 05.06.15.
 */
public class SalaryNettoGreaterThanCriteria extends PersonCriteria {
    private int value;

    public SalaryNettoGreaterThanCriteria(int value) {
        this.value = value;
    }

    public SalaryNettoGreaterThanCriteria(PersonCriteria next, int value) {
        super(next);
        this.value = value;
    }

    @Override
    public Set<Person> performFilter(Set<Person> allPersons) {
        Set<Person> personsWhoEarsMoreThan = new HashSet<>();
        for (Person person : allPersons)
            if (person.getSalary().getNetto() >= value)
                personsWhoEarsMoreThan.add(person);

        return personsWhoEarsMoreThan;
    }

    @Override
    public String toString() {
        return "SalaryNettoGreaterThanCriteria{" +
                "value=" + value +
                "} " + super.toString();
    }
}
