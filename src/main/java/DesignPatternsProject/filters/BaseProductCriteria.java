package DesignPatternsProject.filters;

import DesignPatternsProject.entities.productsAndServices.BaseProduct;

import java.util.Set;

/**
 * Created by lucjan on 06.06.15.
 */
public abstract class BaseProductCriteria {
    private BaseProductCriteria next;

    public abstract Set<BaseProduct> performFilter(Set<BaseProduct> allBaseProducts);

    public BaseProductCriteria() {
    }

    public BaseProductCriteria(BaseProductCriteria next) {
        this.next = next;
    }

    public Set<BaseProduct> doCriteriaFilter(Set<BaseProduct> allBaseProducts) {
        if (getNext() == null)
            return performFilter(allBaseProducts);
        else
            return getNext().doCriteriaFilter(performFilter(allBaseProducts));
    }


    public BaseProductCriteria getNext() {
        return next;
    }

    public void setNext(BaseProductCriteria next) {
        this.next = next;
    }
}
