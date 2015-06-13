package DesignPatternsProject.controllers;

import DesignPatternsProject.DTO.*;
import DesignPatternsProject.entities.productsAndServices.BaseProduct;
import DesignPatternsProject.entities.productsAndServices.Product;
import DesignPatternsProject.services.BaseProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by lucjan on 08.06.15.
 */
@RestController
@RequestMapping(value = "/baseProduct")
public class BaseProductController {

    @Autowired
    private BaseProductService baseProductService;

    @ResponseBody
    @RequestMapping(value = "/createProduct", method = RequestMethod.POST)
    public BaseProductDTOInfo createProduct(@RequestBody ProductFormDTO productFormDTO) {
        return DTOConverter.toBaseProductDTOInfo(
                baseProductService.createProduct(productFormDTO));
    }

    @ResponseBody
    @RequestMapping(value = "/createService", method = RequestMethod.POST)
    public BaseProductDTOInfo createService(@RequestBody ServiceFormDTO serviceFormDTO) {
        return DTOConverter.toBaseProductDTOInfo(
                baseProductService.createService(serviceFormDTO));
    }


    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public Set<BaseProductDTOInfo> deleteBaseProduct(@RequestBody SingleArgumentDTO singleArgumentDTO) {
        baseProductService.deleteBaseProduct(singleArgumentDTO.getValue());
        return baseProductService.getAllBaseProductDTOInfo();
    }


    @ResponseBody
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public Set<BaseProductDTOInfo> getAllBaseProducts() {
        return baseProductService.getAllBaseProductDTOInfo();
    }

}
