package DesignPatternsProject.strategies;



/**
 * Created by lucjan on 29.04.15.
 */
public class Country {

    private Long country_id;
    private String name;
    private Currency currency;        //  symbol waluty na EURO, pomyslex o enum ?
    private double currencyValue;   //  kurs waluty
    private double dutyPercent; // cło

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

    public String getName() {
        return name;
    }

    public Currency getCurrency() {
        return currency;
    }

    public double getCurrencyValue() {
        return currencyValue;
    }

    public double getDutyPercent() {
        return dutyPercent;
    }
}
