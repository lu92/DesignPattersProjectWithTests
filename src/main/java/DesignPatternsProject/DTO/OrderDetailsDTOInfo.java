package DesignPatternsProject.DTO;

import DesignPatternsProject.entities.productsAndServices.BaseProduct;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucjan on 12.06.15.
 */
public class OrderDetailsDTOInfo {
    private Long orderDetailId;
    private String date;
    private PersonDTOInfo client;
    private Set<BaseProductDTOInfo> baseProductDTOInfoSet = new HashSet<>();

    public OrderDetailsDTOInfo() {
    }

    public OrderDetailsDTOInfo(Long orderDetailId, String date, PersonDTOInfo client) {
        this.orderDetailId = orderDetailId;
        this.date = date;
        this.client = client;
    }

    public void addBaseProduct(BaseProduct ... baseProducts) {
        for (BaseProduct baseProduct : baseProducts)
            baseProductDTOInfoSet.add(DTOConverter.toBaseProductDTOInfo(baseProduct));
    }

    public Long getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(Long orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public PersonDTOInfo getClient() {
        return client;
    }

    public void setClient(PersonDTOInfo client) {
        this.client = client;
    }

    public Set<BaseProductDTOInfo> getBaseProductDTOInfoSet() {
        return baseProductDTOInfoSet;
    }

    public void setBaseProductDTOInfoSet(Set<BaseProductDTOInfo> baseProductDTOInfoSet) {
        this.baseProductDTOInfoSet = baseProductDTOInfoSet;
    }
}
