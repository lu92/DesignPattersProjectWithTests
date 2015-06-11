package DesignPatternsProject.entities.productsAndServices;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lucjan on 10.03.15.
 */

//@Entity
public class Category {

//    @Id @GeneratedValue
    private Long category_id;
    private String name;
    private Set<BaseProduct> products = new HashSet<>();


    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(String name, Set<BaseProduct> products) {
        this.name = name;
        this.products = products;
    }

    public void addProducts(BaseProduct ... args) {
        for (BaseProduct product : args)
            products.add(product);
    }

    public void addProducts(List<BaseProduct> baseProductList) {
        for (BaseProduct product : baseProductList)
            products.add(product);
    }

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<BaseProduct> getProducts() {
        return products;
    }

    public void setProducts(Set<BaseProduct> products) {
        this.products = products;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (!name.equals(category.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
