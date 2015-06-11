package DesignPatternsProject.entities.orders;

import DesignPatternsProject.entities.actors.Client;
import DesignPatternsProject.entities.personalData.Address;
import DesignPatternsProject.entities.productsAndServices.BaseProduct;
import DesignPatternsProject.entities.productsAndServices.Category;
import DesignPatternsProject.entities.productsAndServices.Product;
import DesignPatternsProject.entities.productsAndServices.Service;
import DesignPatternsProject.strategies.Country;
import DesignPatternsProject.strategies.taxations.TaxationStrategy;

import java.util.*;

/**
 * Created by lucjan on 29.04.15.
 */
public abstract class AbstractOrderDetails {
    protected Long order_id;
    protected Date date;
    protected TaxationStrategy taxation;
    protected Client client;
    protected Set<BaseProduct> order = new HashSet<>();

    public AbstractOrderDetails() {
    }

    public AbstractOrderDetails(String date, TaxationStrategy taxationStrategy, Client client) {
        this.date = new Date(date);
        this.taxation = taxationStrategy;
        this.client = client;
        taxationStrategy.setOrderDetails(this);
    }

    public void addAnyBaseProduct(BaseProduct... baseProducts) {
        for (BaseProduct anyBaseProduct : baseProducts)
            order.add(anyBaseProduct);
    }

    public void addProduct(Product ... products) {
        for (Product product : products)
            order.add(product);
    }


    public void addService(Service ... services) {
        for(Service service : services)
            order.add(service);
    }

    public void removeProduct(Product product) {
        order.remove(product);
    }



    public Long getOrder_id() {
        return order_id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDate() {
        return date;
    }

    public Set<BaseProduct> getOrder() {
        return order;
    }

    public int getContentSize() {
        return order.size();
    }

    public double calculatePercentDiscount(double percent) {
        return percent * getTotalBruttoPrice() / 100;
    }


    public double calculateNewPriceByPercentDiscount(double percent) {
        return (100-percent)*getTotalBruttoPrice() / 100;
    }

    public double calculateNewPriceByAmountDiscount(double amount) {
        return getTotalBruttoPrice()-amount;
    }

/*
    public double getPriceInApproprateCurrency(Country country, double price) throws IllegalArgumentException{
        if (price < 0)
            throw new IllegalArgumentException("price can't be negative number");
        else
            return price
    }
*/

    public double getTotalBruttoPrice() {
        return getTotalNettoPrice() + taxation.calculateTax() + taxation.calculateDuty();
    }
    public double getTotalNettoPrice() {
        double total = 0.0;
        for (BaseProduct baseProduct : getOrder())
            total += baseProduct.getNetto();
        return total;
    }

    public List<Product> getOnlyProducts() {
        List<Product> onlyProducts = new ArrayList<>();
        for (BaseProduct product : order)
            if (product instanceof Product)
                onlyProducts.add((Product) product);
        return onlyProducts;
    }

    public List<Service> getOnlyServices() {
        List<Service> onlyServices = new ArrayList<>();
        for (BaseProduct product : order)
            if (product instanceof Service)
                onlyServices.add((Service) product);
        return onlyServices;
    }

    public TaxationStrategy getTaxation() {
        return taxation;
    }

    public void setTaxation(TaxationStrategy taxation) {
        this.taxation = taxation;
    }

    public Address getAddress() {
        return client.getAddress();
    }

    public List<Category> getCategories() {
        return null;
    }

    public double getTax() {
        return taxation.calculateTax();
    }

    public double getPriceBySelectedTaxaction() {
        return 0;
    }
}
