package DesignPatternsProject.strategies.taxations;

import DesignPatternsProject.entities.orders.AbstractOrderDetails;
import DesignPatternsProject.entities.productsAndServices.BaseProduct;
import DesignPatternsProject.entities.productsAndServices.Category;
import DesignPatternsProject.resources.CategoryResources;
import DesignPatternsProject.strategies.Country;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lucjan on 01.05.15.
 */
public class UsaTaxation implements TaxationStrategy{

//    private static final int TAX = 10;
    private Country country;
    private AbstractOrderDetails orderDetails;
//    private Map<Category, Double> UsaTaxation = new HashMap<>(); // tutaj sa przechowywane wszystkie opodatkowania ze wzgledu na kategorie

    private Map<Category, Double> UsaTaxation = initTaxation();
    public UsaTaxation() {
    }

    public UsaTaxation(Country country) {
        this.country = country;
    }

    public void addCategoryWithTaxation(Category category, double taxation) {
        UsaTaxation.putIfAbsent(category, taxation);
    }

    public int getNumberOfTaxedCategories() {
        return UsaTaxation.size();
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
        double tax = 0.0;
        for (BaseProduct baseProduct : orderDetails.getOrder())
            for (Map.Entry<Category, Double> entry : UsaTaxation.entrySet())
                if (baseProduct.getCategory().equals(entry.getKey())) {
//                    System.out.println(entry.getKey().getName() + " " + entry.getValue());
                    tax += (baseProduct.getNetto() * entry.getValue() / 100);
                }
        return tax;
    }

    @Override
    public double calculateDuty() {
        return country.getDutyPercent() * (orderDetails.getTotalNettoPrice() + getTax()) / 100;
    }

    @Override
    public int getTax() {
        return -1;  // doesn't usable
    }

    public Map<Category, Double> getUsaTaxation() {
        return UsaTaxation;
    }

    public void setUsaTaxation(Map<Category, Double> usaTaxation) {
        UsaTaxation = usaTaxation;
    }


    private Map<Category, Double> initTaxation() {
        Map<Category, Double> init = new HashMap<>();
        init.putIfAbsent(CategoryResources.getConsultingCategory(), 10.0);
        init.putIfAbsent(CategoryResources.getImplementationCategory(), 15.0);
        init.putIfAbsent(CategoryResources.getSecureCategory(), 20.0);
        return init;
    }
}
