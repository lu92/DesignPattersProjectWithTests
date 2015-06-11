package DesignPatternsProject.filters.productAndServiceFilters;

import DesignPatternsProject.entities.productsAndServices.BaseProduct;
import DesignPatternsProject.filters.BaseProductCriteria;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucjan on 05.06.15.
 */
public class NameCriteria extends BaseProductCriteria {

    private String nameCriteria;

    public NameCriteria(String name) {
        this.nameCriteria = name;
    }

    public NameCriteria(BaseProductCriteria next, String name) {
        super(next);
        this.nameCriteria = name;
    }

    @Override
    public Set<BaseProduct> performFilter(Set<BaseProduct> allBaseProducts) {
        Set<BaseProduct> baseProductFindedByName = new HashSet<>();
        for (BaseProduct baseProduct : allBaseProducts) {
            if (baseProduct.getName().equals(nameCriteria))
                baseProductFindedByName.add(baseProduct);
        }
        return baseProductFindedByName;
    }
}
