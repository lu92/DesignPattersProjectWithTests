package DesignPatternsProject.DTO;

/**
 * Created by lucjan on 13.06.15.
 */
public class ProductFormDTO {
    private String name;
    private double netto;
    private Long categoryId;

    public ProductFormDTO() {
    }

    public ProductFormDTO(String name, double netto, Long categoryId) {
        this.name = name;
        this.netto = netto;
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getNetto() {
        return netto;
    }

    public void setNetto(double netto) {
        this.netto = netto;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
