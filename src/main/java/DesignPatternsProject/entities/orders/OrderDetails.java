package DesignPatternsProject.entities.orders;


import DesignPatternsProject.entities.actors.Client;
import DesignPatternsProject.strategies.taxations.TaxationStrategy;

/**
 * Created by lucjan on 10.03.15.
 */
public class OrderDetails extends AbstractOrderDetails{

    public OrderDetails() {
    }

    public OrderDetails(String date, TaxationStrategy taxationStrategy, Client client) {
        super(date, taxationStrategy, client);
    }
}
