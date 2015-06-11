package DesignPatternsProject.entities.productsAndServices;


/**
 * Created by lucjan on 10.03.15.
 */
public class Product extends BaseProduct {
    public Product() {
    }

    public Product(String name, double netto) {
        super(name, netto);
    }

    public Product(String name, double netto, Category category) {
        super(name, netto, category);
    }

}
