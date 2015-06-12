package DesignPatternsProject.entities.productsAndServices;


import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucjan on 10.03.15.
 */

@NodeEntity
public class Category {


    @GraphId
    private Long category_id;
    private String name;

    @Fetch @RelatedTo(type = "CATEGORY_BASEPRODUCT", direction = Direction.BOTH)
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


    @Override
    public String toString() {
        return "Category{" +
                "category_id=" + category_id +
                ", name='" + name + '\'' +
                '}';
    }
}
