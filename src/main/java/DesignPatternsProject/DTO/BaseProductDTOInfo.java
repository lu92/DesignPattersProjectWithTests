package DesignPatternsProject.DTO;

/**
 * Created by lucjan on 12.06.15.
 */
public class BaseProductDTOInfo {
    private Long baseProductId;
    private String name;
    private double brutto;
    private String categoryName;

    public BaseProductDTOInfo() {
    }


    public BaseProductDTOInfo(Long baseProductId, String name, double brutto, String categoryName) {
        this.baseProductId = baseProductId;
        this.name = name;
        this.brutto = brutto;
        this.categoryName = categoryName;
    }

    public Long getBaseProductId() {
        return baseProductId;
    }

    public void setBaseProductId(Long baseProductId) {
        this.baseProductId = baseProductId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBrutto() {
        return brutto;
    }

    public void setBrutto(double brutto) {
        this.brutto = brutto;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
