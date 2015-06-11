package DesignPatternsProject.entities.personalData;

import DesignPatternsProject.entities.actors.Person;
import org.neo4j.graphdb.Direction;
import org.springframework.data.annotation.Transient;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import java.util.Date;

/**
 * Created by lucjan on 10.03.15.
 */
@NodeEntity
@TypeAlias("Personality")
public class Personality {

    @GraphId
    private Long personality_id;
    private String name;
    private String lastname;
    private Date birth;
    private String telephoneNumber;


    @Fetch @RelatedTo(type = "PERSON_PERSONALITY", direction = Direction.BOTH)
    private Person person;

    public Personality() {
    }

    public Personality(String name, String lastname, String telephoneNumber) {
        if (name == null || lastname == null || telephoneNumber == null)
            throw new IllegalArgumentException("detect one or many null parameter pointers");
        else if (name.isEmpty() || lastname.isEmpty() || telephoneNumber.isEmpty())
            throw new IllegalArgumentException("one or many parameter is empty");
        else if (!name.matches("[a-zA-Z]+") || !lastname.matches("[a-zA-Z]+"))
            throw new IllegalArgumentException("name or lastname parameter don't match to patter");
        else if (!telephoneNumber.matches("[0-9]{9}"))
            throw new IllegalArgumentException("telephone number doesn't match to pattern");
        else {
            this.name = name;
            this.lastname = lastname;
            this.telephoneNumber = telephoneNumber;
        }
    }

    public Personality(String name, String lastname, Date birth, String telephoneNumber) throws IllegalArgumentException{
        if  (birth == null)
            throw new IllegalArgumentException("detect one or many null parameter pointers");
        else {
            this.birth = birth;
        }
    }

    public Personality(String name, String lastname, String birth, String telephoneNumber) throws IllegalArgumentException{
        this(name, lastname, telephoneNumber);
        if (!birth.matches("[0-3]{1}[0-9]{1}/[0-3]{1}[0-9]{1}/[0-9]{4}"))
            throw new IllegalArgumentException("birth doesn't match to pattern");
        else
            this.birth = new Date(birth);
    }
    public Personality(Long personality_id, String name, String lastname, String birth, String telephoneNumber) {
        this(name, lastname, birth, telephoneNumber);
        this.personality_id = personality_id;
    }

    public Personality(Long personality_id, String name, String lastname, Date birth, String telephoneNumber) {
        this(name, lastname, birth, telephoneNumber);
        this.personality_id = personality_id;
    }



    //      EQUALS      AND     HASH_CODE

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Personality that = (Personality) o;

        if (!birth.equals(that.birth)) return false;
        if (!lastname.equals(that.lastname)) return false;
        if (!name.equals(that.name)) return false;
        if (!telephoneNumber.equals(that.telephoneNumber)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + lastname.hashCode();
        result = 31 * result + birth.hashCode();
        result = 31 * result + telephoneNumber.hashCode();
        return result;
    }


    //            METHODS

    public String getStringBirth() {
        return String.valueOf(birth);
    }

    //          END OF METHODS

    public Long getPersonality_id() {
        return personality_id;
    }

    public void setPersonality_id(Long personality_id) {
        this.personality_id = personality_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @Override
    public String toString() {
        return "Personality{" +
                "personality_id=" + personality_id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", birth=" + birth +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                '}';
    }
}
