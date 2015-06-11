package DesignPatternsProject.filters.personFilters;

import DesignPatternsProject.entities.actors.Person;
import DesignPatternsProject.filters.PersonCriteria;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucjan on 04.06.15.
 */
public class SalaryBruttoLessThanCriteria extends PersonCriteria {

    private int value;

    public SalaryBruttoLessThanCriteria(int value) {
        this.value = value;
    }

    public SalaryBruttoLessThanCriteria(PersonCriteria next, int value) {
        super(next);
        this.value = value;
    }

    @Override
    public Set<Person> performFilter(Set<Person> allPersons) {
        Set<Person> personsWhoEarsLessThan = new HashSet<>();
        for (Person person : allPersons)
            if (person.getSalary() != null)
                if (person.getSalary().getBrutto() <= value)
                    personsWhoEarsLessThan.add(person);

        return personsWhoEarsLessThan;
    }

    @Override
    public String toString() {
        return "SalaryBruttoLessThanCriteria{" +
                "value=" + value +
                "} " + super.toString();
    }
}
