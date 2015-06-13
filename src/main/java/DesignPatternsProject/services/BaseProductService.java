package DesignPatternsProject.services;

import DesignPatternsProject.DTO.BaseProductDTOInfo;
import DesignPatternsProject.DTO.ProductFormDTO;
import DesignPatternsProject.DTO.ServiceFormDTO;
import DesignPatternsProject.entities.productsAndServices.BaseProduct;

import java.util.Set;

/**
 * Created by lucjan on 08.06.15.
 */
public interface BaseProductService {
    BaseProduct createProduct(ProductFormDTO productFormDTO);
    BaseProduct createService(ServiceFormDTO serviceFormDTO);
    void deleteBaseProduct(long id);
    Set<BaseProductDTOInfo> getAllBaseProductDTOInfo();

}
