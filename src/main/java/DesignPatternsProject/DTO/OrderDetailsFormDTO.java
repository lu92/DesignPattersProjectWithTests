package DesignPatternsProject.DTO;

import DesignPatternsProject.strategies.taxations.TaxationType;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucjan on 13.06.15.
 */
public class OrderDetailsFormDTO {
    private String date;
    private Long clientId;
    private TaxationType taxationType;
    private Set<Long> baseProductSet = new HashSet<>();


    public OrderDetailsFormDTO() {
    }

    public OrderDetailsFormDTO(String date, Long clientId) {
        this.date = date;
        this.clientId = clientId;
    }

    public OrderDetailsFormDTO(String date, Long clientId, TaxationType taxationType) {
        this.date = date;
        this.clientId = clientId;
        this.taxationType = taxationType;
    }

    public OrderDetailsFormDTO(String date, Long clientId, TaxationType taxationType, Set<Long> baseProductSet) {
        this.date = date;
        this.clientId = clientId;
        this.taxationType = taxationType;
        this.baseProductSet = baseProductSet;
    }

    public void addBaseProduct(Long ... baseProductsId) {
        for (Long id : baseProductsId)
            baseProductSet.add(id);
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Set<Long> getBaseProductSet() {
        return baseProductSet;
    }

    public void setBaseProductSet(Set<Long> baseProductSet) {
        this.baseProductSet = baseProductSet;
    }

    public TaxationType getTaxationType() {
        return taxationType;
    }

    public void setTaxationType(TaxationType taxationType) {
        this.taxationType = taxationType;
    }
}
