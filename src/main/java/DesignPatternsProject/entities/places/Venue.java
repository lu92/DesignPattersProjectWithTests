package DesignPatternsProject.entities.places;

import DesignPatternsProject.entities.orders.Mark;
import DesignPatternsProject.entities.personalData.Address;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucjan on 10.03.15.
 */

public abstract class Venue {   // miejsce spotkan

    private Long id;
    private String name;
    private double rate;
    private Address address;
    private List<Mark> marks = new ArrayList<>();



    public Venue() {
    }

    public Venue(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Venue(String name, double rate, List<Mark> marks, Address address) {
        this.name = name;
        this.rate = rate;
        this.marks = marks;
        this.address = address;
    }

    public Venue(Long id, String name, double rate, List<Mark> marks, Address address) {
        this(name, rate, marks, address);
        this.id = id;
    }



    public void addMarks(Integer ... args) {
        for (Integer i : args)
            marks.add(new Mark(i ,""));
        calculateRate();
    }

    public void addMarks(Mark ... args) {
        for (Mark mark : args)
            marks.add(mark);
        calculateRate();
    }

    private void calculateRate() {
        double sum = 0;
        for (Mark mark : marks)
            sum += mark.getMark();
        rate = sum / marks.size();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getRate() {
        return rate;
    }


    public List<Mark> getMarks() {
        return marks;
    }

    public void setMarks(List<Mark> marks) {
        this.marks = marks;
        calculateRate();
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
