package DesignPatternsProject.filters.personFilters;

import DesignPatternsProject.entities.actors.Person;
import DesignPatternsProject.entities.personalData.EmploymentContractType;
import DesignPatternsProject.filters.PersonCriteria;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucjan on 05.06.15.
 */
public class FixedTermEmploymentTypeCriteria extends PersonCriteria {

    public FixedTermEmploymentTypeCriteria() {
    }

    public FixedTermEmploymentTypeCriteria(PersonCriteria next) throws IllegalArgumentException {
        super(next);
    }

    @Override
    public Set<Person> performFilter(Set<Person> allPersons) {
        Set<Person> personsFindedByFixedTermEmploymentType = new HashSet<>();
        for (Person person : allPersons)
            if (person.getSalary().getType() == EmploymentContractType.FIXED_TERM_EMPLOYMENT)
                personsFindedByFixedTermEmploymentType.add(person);

        return personsFindedByFixedTermEmploymentType;
    }

    @Override
    public String toString() {
        return "FixedTermEmploymentTypeCriteria{} " + super.toString();
    }
}
