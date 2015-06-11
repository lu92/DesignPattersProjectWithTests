package DesignPatternsProject.resources;

import DesignPatternsProject.entities.productsAndServices.Category;

/**
 * Created by lucjan on 06.06.15.
 */
public class CategoryResources {

    public static Category getSecureCategory() {
        Category category = new Category("Secure");
        category.addProducts(BaseProductResource.getSystemSecure());
        return category;
    }

    public static Category getImplementationCategory() {
        Category category = new Category("Implementation");
        category.addProducts(
                BaseProductResource.getImplementationSystemERP(),
                BaseProductResource.getImplemetationSystemCRM());
        return category;
    }

    public static Category getConsultingCategory() {
        Category category = new Category("Consulting");
        category.addProducts(BaseProductResource.getConsulting());
        return category;
    }
}
