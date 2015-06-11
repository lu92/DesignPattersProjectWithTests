package DesignPatternsProject.builders;

import DesignPatternsProject.entities.actors.*;
import DesignPatternsProject.entities.personalData.Address;
import DesignPatternsProject.entities.personalData.Personality;
import DesignPatternsProject.entities.personalData.Role;
import DesignPatternsProject.entities.personalData.Salary;

import java.util.Date;

/**
 * Created by lucjan on 30.03.15.
 */
public class PersonBuilder implements AbstractPersonBuilder{

    protected Person person;
    protected Class clazz;

    public PersonBuilder(String username,String password, String email, Class clazz) throws IllegalArgumentException {
        preparePersonFromClassType(username, password, email, clazz);
    }

    public PersonBuilder(String username,String password, String email, String type) throws IllegalArgumentException {
       preparePersonFromStringType(username, password, email, type);
    }

    public PersonBuilder(
            String username,String password, String email,
            Class clazz, Personality personality, Role role,
            Address address) throws IllegalArgumentException {

        preparePersonFromClassType(username, password, email, clazz);
        setPersonality(personality);
        addRole(role);
        setAddress(address);
    }

    public PersonBuilder(
            String username,String password, String email,
            String type, Personality personality, Role role,
            Address address) throws IllegalArgumentException {

        preparePersonFromStringType(username, password, email, type);
        setPersonality(personality);
        addRole(role);
        setAddress(address);
    }

    private  void preparePersonFromStringType(String username, String password, String email, String type) {
        String properTypeVales [] = {"client", "consultant", "manager", "student", "worker"};
        Class PersonsTypes [] = {Client.class, Manager.class, Student.class, Worker.class };

        int n = 0;

        for (int i=0; i<properTypeVales.length; i++) {
            if (properTypeVales[i].equalsIgnoreCase(type)) {
                preparePersonFromClassType(username, password, email, PersonsTypes[i]);
            }
            else n++;
        }

        if (n == properTypeVales.length)
            throw new IllegalArgumentException("constructor cannot set invalid name of Person Object");
    }

    private void preparePersonFromClassType(String username, String password, String email, Class clazz) throws IllegalArgumentException {
        this.clazz = clazz;
        switch (clazz.getName()) {
            case "DesignPatternsProject.entities.actors.Client":
                person = new Client(username, password, email);
                break;
            case "DesignPatternsProject.entities.actors.Manager":
                person = new Manager(username, password, email);
                break;
            case "DesignPatternsProject.entities.actors.Student":
                person = new Student(username, password, email);
                break;
            case "DesignPatternsProject.entities.actors.Worker":
                person = new Worker(username, password, email);
                break;
            default:
                throw new IllegalArgumentException("constructor cannot set invalid type of Person Object");
        }
    }


    @Override
    public void setPersonality(String name, String lastname, Date birth, String telephoneNumber) {
        person.setPersonality(new Personality(name, lastname, birth, telephoneNumber));
    }

    @Override
    public void setPersonality(String name, String lastname, String birth, String telephoneNumber){
        person.setPersonality( new Personality(name, lastname, birth, telephoneNumber));
    }

    @Override
    public void setPersonality(Personality personality) {
        person.setPersonality(personality);
    }

    @Override
    public void setRole(String roleName) throws IllegalArgumentException {

    }

    @Override
    public void addRole(Role role) {
        person.addRoles(role);
    }

    @Override
    public void addRoles(Role... roles) {
        for (Role role : roles)
            person.getRoleStorage().add(role);
    }

    @Override
    public void setAddress(String country, String city, String street, String zipCode) {
        person.setAddress(new Address(country, city, street, zipCode));
    }

    @Override
    public void setAddress(Address address) {
        person.setAddress(address);
    }

    @Override
    public void setSalary(Salary salary) {
        person.setSalary(salary);
    }

    @Override
    public Class getClassPersonType() {
        return clazz;
    }

    @Override
    public String getPersonType() {
        return clazz.getName();
    }

    @Override
    public Person getBuildResult() {
        return person;
    }

    @Override
    public void printPerson() {
        System.out.println(person);
    }
}
