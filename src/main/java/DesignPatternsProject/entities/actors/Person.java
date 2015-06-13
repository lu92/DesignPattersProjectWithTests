package DesignPatternsProject.entities.actors;

import DesignPatternsProject.entities.Comunication.Mail;
import DesignPatternsProject.entities.personalData.Address;
import DesignPatternsProject.entities.personalData.Personality;
import DesignPatternsProject.entities.personalData.Role;
import DesignPatternsProject.entities.personalData.Salary;
import DesignPatternsProject.entities.productsAndServices.Category;
import DesignPatternsProject.entities.productsAndServices.Service;
import org.neo4j.graphdb.Direction;
import org.springframework.data.annotation.Transient;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.*;


import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucjan on 10.03.15.
 */
@NodeEntity
@TypeAlias("Person")
public class Person {

    @GraphId
    private Long id;
    private String username;
    private String password;
    private String email;

    @Fetch @RelatedTo(type = "PERSON_PERSONALITY", direction = Direction.BOTH)
    private Personality personality;

    @Fetch @RelatedTo(type = "PERSON_ADDRESS", direction = Direction.BOTH)
    private Address address;

    @Fetch @RelatedTo(type = "PERSON_ROLE", direction = Direction.BOTH)
    private Set<Role> roleStorage = new HashSet<>();


    @Fetch
    @RelatedTo(type = "PERSON_SALARY", direction = Direction.BOTH)
    private Salary salary;


    @Fetch
    @RelatedTo(type = "PERSON_SERVICE", direction = Direction.BOTH)
    private Set<Service> serviceStorage = new HashSet<>();


    @Fetch @RelatedToVia(type = "MAIL_TO", direction = Direction.BOTH)
//    @Transient
    private Set<Mail> mailStorage = new HashSet<>();


    public Person() {
    }


    public Person(String username, String password, String email) throws IllegalArgumentException{
        if (username == null || password == null || email == null)
            throw new IllegalArgumentException("detect one or many null parameter pointers");
        else if (username.isEmpty() || password.isEmpty() || email.isEmpty())
            throw new IllegalArgumentException("one or many parameter is empty");
        else if (!email.matches("[a-zA-z0-9.]+@[a-zA-z0-9]+.[a-z]+"))
            throw new IllegalArgumentException("email doesn't match to patern");
        else {
            this.username = username;
            this.password = password;
            this.email = email;
        }
    }

    public Person(String username, String password, String email, Personality personality, Address address, Set<Role> role, Salary salary) throws IllegalArgumentException{
        this(username, password, email);
        if (personality == null || address == null || roleStorage == null || salary == null)
            throw new IllegalArgumentException("detect one or many null parameter pointers");
        else {
            this.personality = personality;
            this.address = address;
            this.roleStorage = role;
            this.salary = salary;
        }
    }

    public Person(Long person_id, String username, String password, String email, Personality personality, Address address, Set<Role> role, Salary salary) throws IllegalArgumentException{
        this(username, password, email, personality, address, role, salary);
        if (person_id == null )
            throw new IllegalArgumentException("detect one or many null parameter pointers");
        else {
            this.id = person_id;
        }
    }

    public void addRoles(Role ... roles) {
        for (Role role : roles) {
            getRoleStorage().add(role);
        }
    }

    public void addMail(Mail mail) throws IllegalArgumentException{
        if (mail == null)
            throw new IllegalArgumentException("mail can't be null");
        else
            mailStorage.add(mail);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (address != null ? !address.equals(person.address) : person.address != null) return false;
        if (!email.equals(person.email)) return false;
        if (!password.equals(person.password)) return false;
        if (id != null ? !id.equals(person.id) : person.id != null) return false;
        if (personality != null ? !personality.equals(person.personality) : person.personality != null) return false;
        if (roleStorage != null ? !roleStorage.equals(person.roleStorage) : person.roleStorage != null) return false;
        if (!username.equals(person.username)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + username.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + (personality != null ? personality.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (roleStorage != null ? roleStorage.hashCode() : 0);
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Personality getPersonality() {
        return personality;
    }

    public void setPersonality(Personality personality) {
        this.personality = personality;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Set<Role> getRoleStorage() {
        return roleStorage;
    }

    public void setRoleStorage(Set<Role> roleStorage) {
        this.roleStorage = roleStorage;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Set<Mail> getMailStorage() {
        return mailStorage;
    }

    public void setMailStorage(Set<Mail> mailStorage) {
        this.mailStorage = mailStorage;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", personality=" + personality +
                ", address=" + address +
                ", roleStorage=" + roleStorage +
                ", salary=" + salary +
                '}';
    }



}
