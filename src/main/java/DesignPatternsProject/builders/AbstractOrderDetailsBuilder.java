package DesignPatternsProject.builders;

import DesignPatternsProject.entities.orders.AbstractOrderDetails;
import DesignPatternsProject.strategies.Country;
import DesignPatternsProject.strategies.taxations.TaxationStrategy;

import java.util.Iterator;

/**
 * Created by lucjan on 01.05.15.
 */
public class AbstractOrderDetailsBuilder {
    protected AbstractOrderDetails orderDetails;
    protected Country country;
    protected TaxationStrategy taxation;
    protected Iterator iterator;    // iterator do poszczegolnego obliczania ze wzgledu na kategorie
}
