package DesignPatternsProject.strategies.taxations;


import DesignPatternsProject.entities.orders.AbstractOrderDetails;
import DesignPatternsProject.strategies.Country;

/**
 * Created by lucjan on 01.04.15.
 */
public interface TaxationStrategy {
    public void setCountry(Country country);
    public void setOrderDetails(AbstractOrderDetails orderDetails);
    public double calculateTax();
    public double calculateDuty();
    public int getTax();
}
