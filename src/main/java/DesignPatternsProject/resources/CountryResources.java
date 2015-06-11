package DesignPatternsProject.resources;

import DesignPatternsProject.strategies.Country;
import DesignPatternsProject.strategies.Currency;


/**
 * Created by lucjan on 09.06.15.
 */
public class CountryResources {

    public static Country getPoland() {
        return new Country("Poland", Currency.PLN, 1.0, 0);
    }

    public static Country getUnitedStates() {
        return new Country("United States", Currency.USD, 3.70, 10.0);
    }
}
