package DesignPatternsProject.filters.productAndServiceFilters;

import DesignPatternsProject.entities.productsAndServices.BaseProduct;
import DesignPatternsProject.filters.BaseProductCriteria;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucjan on 05.06.15.
 */
public class PriceNettoGreaterThanCriteria extends BaseProductCriteria{

    private double value;

    public PriceNettoGreaterThanCriteria(double value) {
        this.value = value;
    }

    public PriceNettoGreaterThanCriteria(BaseProductCriteria next, double value) {
        super(next);
        this.value = value;
    }

    @Override
    public Set<BaseProduct> performFilter(Set<BaseProduct> allBaseProducts) {
        Set<BaseProduct> baseProductsWhichCostMoreThan = new HashSet<>();
        for (BaseProduct baseProduct : allBaseProducts)
            if (baseProduct.getNetto() >= value)
                baseProductsWhichCostMoreThan.add(baseProduct);

        return baseProductsWhichCostMoreThan;
    }

}
