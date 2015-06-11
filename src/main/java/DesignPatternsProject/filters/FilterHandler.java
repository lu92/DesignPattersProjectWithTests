package DesignPatternsProject.filters;

import DesignPatternsProject.entities.actors.Person;

import java.util.Set;

/**
 * Created by lucjan on 04.06.15.
 */
public class FilterHandler {
    private PersonCriteria begin;
    private Set<Person> allPersons;

    public FilterHandler() {
    }

    public FilterHandler(Set<Person> allPersons) {
        this.allPersons = allPersons;
    }

    public Set<Person> doFilter() {
        return begin.doCriteriaFilter(allPersons);
    }

    public PersonCriteria getBegin() {
        return begin;
    }

    public void setBegin(PersonCriteria begin) {
        this.begin = begin;
    }

}
