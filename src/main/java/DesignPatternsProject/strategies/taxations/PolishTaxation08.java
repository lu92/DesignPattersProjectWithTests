package DesignPatternsProject.strategies.taxations;


import DesignPatternsProject.entities.orders.AbstractOrderDetails;
import DesignPatternsProject.strategies.Country;

/**
 * Created by lucjan on 01.04.15.
 */
public class PolishTaxation08 implements TaxationStrategy {

    private static final int TAX = 8;
    private Country country;
    private AbstractOrderDetails orderDetails;

    public PolishTaxation08(Country country) throws IllegalArgumentException{
        if (country == null)
            throw new IllegalArgumentException("country mustn't be null object");
        else
            this.country = country;
    }

    @Override
    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public void setOrderDetails(AbstractOrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }

    @Override
    public double calculateTax() {
        double netto = orderDetails.getTotalNettoPrice();
        return TAX * netto / 100;
    }

    @Override
    public double calculateDuty() {
        return country.getDutyPercent() *orderDetails.getTotalNettoPrice() / 100;
    }

    @Override
    public int getTax() {
        return TAX;
    }
}
