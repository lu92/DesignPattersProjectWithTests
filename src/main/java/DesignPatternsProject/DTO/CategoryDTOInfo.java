package DesignPatternsProject.DTO;

import DesignPatternsProject.entities.productsAndServices.BaseProduct;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucjan on 12.06.15.
 */
public class CategoryDTOInfo {
    private Long categoryId;
    private String name;
    private Set<BaseProductDTOInfo> baseProductDTOInfoSet = new HashSet<>();


    public CategoryDTOInfo() {
    }


    public CategoryDTOInfo(Long categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }


    public void addBaseProduct(BaseProduct ... baseProducts) {
        for (BaseProduct baseProduct : baseProducts)
            baseProductDTOInfoSet.add(DTOConverter.toBaseProductDTOInfo(baseProduct));
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<BaseProductDTOInfo> getBaseProductDTOInfoSet() {
        return baseProductDTOInfoSet;
    }

    public void setBaseProductDTOInfoSet(Set<BaseProductDTOInfo> baseProductDTOInfoSet) {
        this.baseProductDTOInfoSet = baseProductDTOInfoSet;
    }
}
