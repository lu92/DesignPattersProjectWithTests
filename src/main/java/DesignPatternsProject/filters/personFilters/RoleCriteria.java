package DesignPatternsProject.filters.personFilters;

import DesignPatternsProject.entities.actors.Person;
import DesignPatternsProject.entities.personalData.Role;
import DesignPatternsProject.filters.PersonCriteria;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucjan on 04.06.15.
 */
public class RoleCriteria extends PersonCriteria {
    private String roleCriteria;

    public RoleCriteria(String roleCriteria) {
        this.roleCriteria = roleCriteria;
    }

    public RoleCriteria(PersonCriteria next, String roleCriteria) {
        super(next);
        this.roleCriteria = roleCriteria;
    }

    @Override
    public Set<Person> performFilter(Set<Person> allPersons) {
        Set<Person> personsFindedByRole = new HashSet<>();
        for (Person person : allPersons)
            for (Role role : person.getRoleStorage())
                if (role.getName().equals(roleCriteria)) {
                    personsFindedByRole.add(person);
                    break;
                }
        return personsFindedByRole;
    }

    @Override
    public String toString() {
        return "RoleCriteria{" +
                "roleCriteria='" + roleCriteria + '\'' +
                "} " + super.toString();
    }
}
