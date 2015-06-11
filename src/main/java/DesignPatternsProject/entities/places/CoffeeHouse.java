package DesignPatternsProject.entities.places;

import DesignPatternsProject.entities.orders.Mark;
import DesignPatternsProject.entities.personalData.Address;

import java.util.List;

/**
 * Created by lucjan on 31.03.15.
 */
public class CoffeeHouse extends Venue {
    public CoffeeHouse() {
    }

    public CoffeeHouse(String name, Address address) {
        super(name, address);
    }

    public CoffeeHouse(String name, double rate, List<Mark> marks, Address address) {
        super(name, rate, marks, address);
    }

    public CoffeeHouse(Long id, String name, double rate, List<Mark> marks, Address address) {
        super(id, name, rate, marks, address);
    }
}
