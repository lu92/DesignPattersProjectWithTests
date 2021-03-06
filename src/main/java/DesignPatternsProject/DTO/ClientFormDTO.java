package DesignPatternsProject.DTO;

import DesignPatternsProject.entities.actors.PersonType;

/**
 * Created by lucjan on 12.06.15.
 */
public class ClientFormDTO {

    private PersonType personType = PersonType.CLIENT;
    private String username;
    private String password;
    private String email;

    private String name;
    private String lastName;
    private String birth;
    private String telephoneNumber;

    private String country;
    private String city;
    private String street;
    private String zipCode;

    private String accontNumber;
    private String PIN;


    public ClientFormDTO(String username, String password, String email,
                         String name, String lastName, String birth, String telephoneNumber,
                         String country, String city, String street, String zipCode,
                         String accontNumber, String PIN) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.lastName = lastName;
        this.birth = birth;
        this.telephoneNumber = telephoneNumber;
        this.country = country;
        this.city = city;
        this.street = street;
        this.zipCode = zipCode;
        this.accontNumber = accontNumber;
        this.PIN = PIN;
    }


    public PersonType getPersonType() {
        return personType;
    }

    public void setPersonType(PersonType personType) {
        this.personType = personType;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAccontNumber() {
        return accontNumber;
    }

    public void setAccontNumber(String accontNumber) {
        this.accontNumber = accontNumber;
    }

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }
}
