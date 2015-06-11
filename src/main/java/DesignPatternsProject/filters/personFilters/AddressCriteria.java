package DesignPatternsProject.filters.personFilters;

import DesignPatternsProject.entities.actors.Person;
import DesignPatternsProject.entities.personalData.Address;
import DesignPatternsProject.filters.PersonCriteria;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucjan on 04.06.15.
 */
public class AddressCriteria extends PersonCriteria {
    private Address addressCriteria;

    public AddressCriteria(PersonCriteria next, Address addressCriteria) throws IllegalArgumentException{
        super(next);
        if (addressCriteria == null)
            throw new IllegalArgumentException("detect one or many null parameter pointers");
        else
            this.addressCriteria = addressCriteria;
    }

    public AddressCriteria(Address addressCriteria) throws IllegalArgumentException{
        if (addressCriteria == null)
            throw new IllegalArgumentException("address can't be null");
        else
            this.addressCriteria = addressCriteria;
    }


    @Override
    public Set<Person> performFilter(Set<Person> allPersons) {
        Set<Person> personsFindedByAddress = new HashSet<>();
        for (Person person : allPersons)
            if (person.getAddress().equals(addressCriteria))
                personsFindedByAddress.add(person);

        return personsFindedByAddress;
    }



    @Override
    public String toString() {
        return "AddressCriteria{" +
                "addressCriteria=" + addressCriteria +
                "} " + super.toString();
    }
}
