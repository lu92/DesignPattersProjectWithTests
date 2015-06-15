package DesignPatternsProject.DTO;

/**
 * Created by lucjan on 12.06.15.
 */
public class BaseProductDTOInfo {
    private Long baseProductId;
    private String name;
    private double netto;
    private double brutto;
    private String categoryName;
    private boolean showButton = true;

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


    public double getNetto() {
        return netto;
    }

    public void setNetto(double netto) {
        this.netto = netto;
    }

    public boolean isShowButton() {
        return showButton;
    }

    public void setShowButton(boolean showButton) {
        this.showButton = showButton;
    }

    @Override
    public String toString() {
        return "BaseProductDTOInfo{" +
                "baseProductId=" + baseProductId +
                ", name='" + name + '\'' +
                ", netto=" + netto +
                ", brutto=" + brutto +
                ", categoryName='" + categoryName + '\'' +
                ", showButton=" + showButton +
                '}';
    }
}
