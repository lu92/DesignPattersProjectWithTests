package DesignPatternsProject.strategies;


import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 * Created by lucjan on 29.04.15.
 */
@NodeEntity
public class Country {

    @GraphId
    private Long country_id;
    private String name;
    private Currency currency;        //  symbol waluty na EURO, pomyslex o enum ?
    private double currencyValue;   //  kurs waluty
    private double dutyPercent; // cło

    public Country() {
    }

    public Country(String name, Currency currency, double currencyValue, double dutyPercent) {
        this.name = name;
        this.currency = currency;
        this.currencyValue = currencyValue;
        this.dutyPercent = dutyPercent;
    }

    public Country(Long country_id, String name, Currency currency, double currencyValue, double dutyPercent) {
        this(name, currency, currencyValue, dutyPercent);
        this.country_id = country_id;
    }


    public Long getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Long country_id) {
        this.country_id = country_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getCurrencyValue() {
        return currencyValue;
    }

    public void setCurrencyValue(double currencyValue) {
        this.currencyValue = currencyValue;
    }

    public double getDutyPercent() {
        return dutyPercent;
    }

    public void setDutyPercent(double dutyPercent) {
        this.dutyPercent = dutyPercent;
    }
}
