package DesignPatternsProject.filters;

import DesignPatternsProject.entities.actors.Person;

import java.util.Set;

/**
 * Created by lucjan on 04.06.15.
 */
public abstract class PersonCriteria {
    private PersonCriteria next;
    public PersonCriteria() {
    }

    public PersonCriteria(PersonCriteria next) throws IllegalArgumentException{
        if (next == null)
            throw new IllegalArgumentException("detect one or many null parameter pointers");
        else
            this.next = next;
    }
    public abstract Set<Person> performFilter(Set<Person> allPersons);

    public Set<Person> doCriteriaFilter(Set<Person> allPersons) {
        if (getNext() == null)
            return performFilter(allPersons);
        else
            return getNext().doCriteriaFilter(performFilter(allPersons));
    }


    public PersonCriteria getNext() {
        return next;
    }

    public void setNext(PersonCriteria next) {
        this.next = next;
    }
}
