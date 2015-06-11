package DesignPatternsProject.entities.places;

import DesignPatternsProject.entities.orders.Mark;
import DesignPatternsProject.entities.personalData.Address;

import java.util.List;

/**
 * Created by lucjan on 10.03.15.
 */
public class Office extends Venue {
    public Office() {
    }

    public Office(String name, Address address) {
        super(name, address);
    }

    public Office(String name, double rate, List<Mark> marks, Address address) {
        super(name, rate, marks, address);
    }

    public Office(Long id, String name, double rate, List<Mark> marks, Address address) {
        super(id, name, rate, marks, address);
    }
}
