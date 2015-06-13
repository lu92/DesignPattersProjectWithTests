package DesignPatternsProject.DTO;

import DesignPatternsProject.entities.productsAndServices.BaseProductType;

/**
 * Created by lucjan on 13.06.15.
 */
public class BaseProductFormDTO {
    private BaseProductType baseProductType;
    private String name;
    private double netto;

    public BaseProductFormDTO() {
    }

    public BaseProductFormDTO(BaseProductType baseProductType, String name, double netto) {
        this.baseProductType = baseProductType;
        this.name = name;
        this.netto = netto;
    }

    public BaseProductType getBaseProductType() {
        return baseProductType;
    }

    public void setBaseProductType(BaseProductType baseProductType) {
        this.baseProductType = baseProductType;
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
}
