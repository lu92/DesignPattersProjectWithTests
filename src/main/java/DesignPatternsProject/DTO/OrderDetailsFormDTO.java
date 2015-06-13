package DesignPatternsProject.DTO;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucjan on 13.06.15.
 */
public class OrderDetailsFormDTO {
    private String date;
    private Long clientId;
    private Set<BaseProductFormDTO> baseProductFormDTOSet = new HashSet<>();

    public OrderDetailsFormDTO() {
    }

    public OrderDetailsFormDTO(String date, Long clientId) {
        this.date = date;
        this.clientId = clientId;
    }

    public void addBaseProductFormDTO(BaseProductFormDTO ... baseProductFormDTOs) {
        for (BaseProductFormDTO baseProductFormDTO : baseProductFormDTOs)
            baseProductFormDTOSet.add(baseProductFormDTO);

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

    public Set<BaseProductFormDTO> getBaseProductFormDTOSet() {
        return baseProductFormDTOSet;
    }

    public void setBaseProductFormDTOSet(Set<BaseProductFormDTO> baseProductFormDTOSet) {
        this.baseProductFormDTOSet = baseProductFormDTOSet;
    }
}
