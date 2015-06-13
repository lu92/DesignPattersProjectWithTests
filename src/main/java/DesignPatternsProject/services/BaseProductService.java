package DesignPatternsProject.services;

import DesignPatternsProject.DTO.BaseProductDTOInfo;
import DesignPatternsProject.DTO.BaseProductFormDTO;
import DesignPatternsProject.entities.productsAndServices.BaseProduct;

import java.util.Set;

/**
 * Created by lucjan on 08.06.15.
 */
public interface BaseProductService {
    BaseProduct createBaseProduct(BaseProductFormDTO baseProductFormDTO);
    void deleteBaseProduct(long id);
    Set<BaseProductDTOInfo> getAllBaseProductDTOInfo();

}
