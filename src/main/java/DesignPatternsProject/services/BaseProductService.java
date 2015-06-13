package DesignPatternsProject.services;

import DesignPatternsProject.DTO.BaseProductDTOInfo;
import DesignPatternsProject.DTO.ProductFormDTO;
import DesignPatternsProject.DTO.ServiceFormDTO;
import DesignPatternsProject.entities.productsAndServices.BaseProduct;
import DesignPatternsProject.entities.productsAndServices.Product;
import DesignPatternsProject.entities.productsAndServices.Service;

import java.util.Set;

/**
 * Created by lucjan on 08.06.15.
 */
public interface BaseProductService {
    BaseProduct createProduct(ProductFormDTO productFormDTO);
    BaseProduct createService(ServiceFormDTO serviceFormDTO);

    void deleteBaseProduct(long id);
    void deleteAll();

    Set<BaseProduct> getAllBaseProducts();
    Set<BaseProductDTOInfo> getAllBaseProductDTOInfo();

    Set<Product> getAllProducts();
    Set<Service> getAllServices();

    long getNumberOfBaseProducts();
    long getNumberOfProducts();
    long getNumberOfServices();

}
