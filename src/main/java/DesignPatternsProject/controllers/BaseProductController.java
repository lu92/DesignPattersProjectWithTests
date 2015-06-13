package DesignPatternsProject.controllers;

import DesignPatternsProject.DTO.BaseProductDTOInfo;
import DesignPatternsProject.DTO.BaseProductFormDTO;
import DesignPatternsProject.entities.productsAndServices.BaseProduct;
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
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public BaseProduct createBaseProduct(@RequestBody BaseProductFormDTO baseProductFormDTO) {
        return baseProductService.createBaseProduct(baseProductFormDTO);
    }


    @ResponseBody
    @RequestMapping(value = "/delete/{baseProductId}", method = RequestMethod.GET)
    public void deleteBaseProduct(@PathVariable("baseProductId") long baseProductId) {
        baseProductService.deleteBaseProduct(baseProductId);
    }


    @ResponseBody
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public Set<BaseProductDTOInfo> getAllBaseProducts() {
        return baseProductService.getAllBaseProductDTOInfo();
    }

}
