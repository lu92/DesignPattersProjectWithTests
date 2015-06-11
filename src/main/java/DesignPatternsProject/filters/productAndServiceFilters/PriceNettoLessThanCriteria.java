package DesignPatternsProject.filters.productAndServiceFilters;

import DesignPatternsProject.entities.productsAndServices.BaseProduct;
import DesignPatternsProject.filters.BaseProductCriteria;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucjan on 05.06.15.
 */
public class PriceNettoLessThanCriteria extends BaseProductCriteria {

    private double value;

    public PriceNettoLessThanCriteria(double value) {
        this.value = value;
    }

    public PriceNettoLessThanCriteria(BaseProductCriteria next, double value) {
        super(next);
        this.value = value;
    }

    @Override
    public Set<BaseProduct> performFilter(Set<BaseProduct> allBaseProducts) {
        Set<BaseProduct> baseProductsWhichCostLessThan = new HashSet<>();
        for (BaseProduct baseProduct : allBaseProducts)
            if (baseProduct.getNetto() <= value)
                baseProductsWhichCostLessThan.add(baseProduct);

        return baseProductsWhichCostLessThan;
    }

}
