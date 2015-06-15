package DesignPatternsProject.DTO;

import DesignPatternsProject.entities.TaxType;
import DesignPatternsProject.strategies.taxations.TaxationType;

import java.util.Set;

/**
 * Created by lucjan on 15.06.15.
 */
public class PodatkiDTO {
    private TaxationType taxationType;
    private Set<BaseProductDTOInfo> productDTOInfos;

    public TaxationType getTaxationType() {
        return taxationType;
    }

    public void setTaxationType(TaxationType taxationType) {
        this.taxationType = taxationType;
    }

    public Set<BaseProductDTOInfo> getProductDTOInfos() {
        return productDTOInfos;
    }

    public void setProductDTOInfos(Set<BaseProductDTOInfo> productDTOInfos) {
        this.productDTOInfos = productDTOInfos;
    }

    @Override
    public String toString() {
        return "PodatkiDTO{" +
                "taxationType=" + taxationType +
                ", productDTOInfos=" + productDTOInfos +
                '}';
    }
}
