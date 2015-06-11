package DesignPatternsProject.filters.productAndServiceFilters;

import DesignPatternsProject.entities.productsAndServices.BaseProduct;
import DesignPatternsProject.entities.productsAndServices.Category;
import DesignPatternsProject.filters.BaseProductCriteria;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucjan on 06.06.15.
 */
public class CategoryCriteria extends BaseProductCriteria {

    private Category category;

    public CategoryCriteria(Category category) {
        this.category = category;
    }

    public CategoryCriteria(BaseProductCriteria next, Category category) {
        super(next);
        this.category = category;
    }

    @Override
    public Set<BaseProduct> performFilter(Set<BaseProduct> allBaseProducts) {
        Set<BaseProduct> baseProductsWithSelectedCategory = new HashSet<>();
        for (BaseProduct baseProduct : allBaseProducts) {
            if (baseProduct.getCategory().equals(category))
                baseProductsWithSelectedCategory.add(baseProduct);
        }
        return baseProductsWithSelectedCategory;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
