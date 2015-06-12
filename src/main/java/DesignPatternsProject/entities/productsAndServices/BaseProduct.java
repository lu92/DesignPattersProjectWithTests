package DesignPatternsProject.entities.productsAndServices;


import DesignPatternsProject.entities.orders.AbstractOrderDetails;
import org.neo4j.graphdb.Direction;
import org.springframework.data.annotation.Transient;
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
public abstract class BaseProduct {

    @GraphId
    private Long id;
    private String name;
//    private int taxPercent;        // podatek // do usuniecia
//    private double duty;    //  clo // do usuniecia
    private double netto;
    private double brutto;      // to trzeba policzyc ze wzgledu na opodatkowanie


    @Fetch
    @RelatedTo(type = "CATEGORY_BASEPRODUCT", direction = Direction.BOTH)
    private Category category;  // zeby policzyc podatek ze wzgledu na podatek

    @Fetch @RelatedTo(type = "ORDER_BASEPRODUCT", direction = Direction.BOTH)
//    @Transient
    private Set<AbstractOrderDetails> abstractOrderDetailsSet = new HashSet<>();


    public BaseProduct() {
    }

    public BaseProduct(String name, double netto) throws IllegalArgumentException{
        if (name == null || name.isEmpty() || !name.matches("[a-zA-Z0-9 ]+"))
            throw new IllegalArgumentException("name is null or empty or doesn't match to pattern");
        else {
            this.name = name;
            this.netto = netto;
        }
    }

    public BaseProduct(String name, double netto, Category category) throws IllegalArgumentException{
        this(name, netto);
        if (category == null)
            throw new IllegalArgumentException("category is null");
        else
            this.category = category;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BaseProduct that = (BaseProduct) o;

        if (Double.compare(that.netto, netto) != 0) return false;
        if (!name.equals(that.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(netto);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Category getCategory() {
        return category;
    }

    public double getNetto() {
        return netto;
    }

    public double getBrutto() {
        return brutto;
    }

    public void setBrutto(double brutto) {
        this.brutto = brutto;
    }


    @Override
    public String toString() {
        return "BaseProduct{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", netto=" + netto +
                ", brutto=" + brutto +
                ", category=" + category +
                '}';
    }
}
