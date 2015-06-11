package DesignPatternsProject.entities.productsAndServices;


/**
 * Created by lucjan on 10.03.15.
 */

public abstract class BaseProduct {

    private Long id;
    private String name;
//    private int taxPercent;        // podatek // do usuniecia
//    private double duty;    //  clo // do usuniecia
    private double netto;
    private double brutto;      // to trzeba policzyc ze wzgledu na opodatkowanie


    private Category category;  // zeby policzyc podatek ze wzgledu na podatek

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
