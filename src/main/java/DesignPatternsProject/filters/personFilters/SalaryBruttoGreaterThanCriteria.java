package DesignPatternsProject.filters.personFilters;

import DesignPatternsProject.entities.actors.Person;
import DesignPatternsProject.filters.PersonCriteria;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucjan on 04.06.15.
 */
public class SalaryBruttoGreaterThanCriteria extends PersonCriteria {

    private int value;

    public SalaryBruttoGreaterThanCriteria(int value) {
        this.value = value;
    }

    public SalaryBruttoGreaterThanCriteria(PersonCriteria next, int value) {
        super(next);
        this.value = value;
    }

    @Override
    public Set<Person> performFilter(Set<Person> allPersons) {
        Set<Person> personsWhoEarsMoreThan = new HashSet<>();
        for (Person person : allPersons)
            if (person.getSalary() != null)
                if (person.getSalary().getBrutto() >= value)
                    personsWhoEarsMoreThan.add(person);

        return personsWhoEarsMoreThan;
    }

    @Override
    public String toString() {
        return "SalaryBruttoGreaterThanCriteria{" +
                "value=" + value +
                "} " + super.toString();
    }
}
