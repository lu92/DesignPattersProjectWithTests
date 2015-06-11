package DesignPatternsProject.entities.personalData;

import DesignPatternsProject.entities.actors.Person;
import DesignPatternsProject.entities.places.Venue;
import DesignPatternsProject.filters.personFilters.AddressCriteria;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.neo4j.graphdb.Direction;
import org.springframework.data.annotation.Transient;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import javax.persistence.*;

/**
 * Created by lucjan on 10.03.15.
 */
@NodeEntity
public class Address {

    @GraphId
    private Long address_id;
    private String country;
    private String city;
    private String street;
    private String zipCode;

    @JsonIgnore
    @Fetch @RelatedTo(type = "PERSON_ADDRESS", direction = Direction.BOTH)
    private Person person;


    @JsonIgnore
    @Transient
    private Venue venue;

    public Address() {
    }

    public Address(String country, String city, String street, String zipCode) throws IllegalArgumentException{
        if (country == null || city == null || street == null || zipCode == null)
            throw new IllegalArgumentException("detect one or many null parameter pointers");
        else if (country.isEmpty() || city.isEmpty() || street.isEmpty() || zipCode.isEmpty())
            throw new IllegalArgumentException("one or many parameter is empty");
        else if (country.contains(".*\\d.*") || city.contains(".*\\d.*"))
            throw new IllegalArgumentException("country or city contain digit number");
        else if (!isZipCodeValid(zipCode))
            throw new IllegalArgumentException("postal code doesn't match to pattern");
        else {
            this.country = country;
            this.city = city;
            this.street = street;
            this.zipCode = zipCode;
        }

    }

    public Address(Long address_id, String country, String city, String street, String zipCode) {
        this.address_id = address_id;
        this.country = country;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
    }

    public static boolean isZipCodeValid(String zipCode) {
        boolean retval = false;
        String zipCodePattern = "\\d{2}-\\d{3} [a-zA-Z]+";
        retval = zipCode.matches(zipCodePattern);
        return retval;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (!city.equals(address.city)) return false;
        if (!country.equals(address.country)) return false;
        if (!street.equals(address.street)) return false;
        if (!zipCode.equals(address.zipCode)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = country.hashCode();
        result = 31 * result + city.hashCode();
        result = 31 * result + street.hashCode();
        result = 31 * result + zipCode.hashCode();
        return result;
    }

    public Long getAddress_id() {
        return address_id;
    }

    public void setAddress_id(Long address_id) {
        this.address_id = address_id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address_id=" + address_id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}
