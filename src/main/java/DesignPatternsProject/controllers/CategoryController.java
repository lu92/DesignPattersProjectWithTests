package DesignPatternsProject.controllers;

import DesignPatternsProject.DTO.CategoryDTOInfo;
import DesignPatternsProject.DTO.CategoryFormDTO;
import DesignPatternsProject.DTO.SingleArgumentDTO;
import DesignPatternsProject.entities.productsAndServices.Category;
import DesignPatternsProject.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

/**
 * Created by lucjan on 13.06.15.
 */
@RestController
@RequestMapping(value = "/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @ResponseBody
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Set<CategoryDTOInfo> createCategory(@RequestBody CategoryFormDTO categoryFormDTO) {
        categoryService.createCategory(categoryFormDTO);
        return categoryService.getAllCategoryDtoInfos();
    }

    @ResponseBody
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Set<CategoryDTOInfo> deleteCategory(@RequestBody SingleArgumentDTO singleArgumentDTO) {
        categoryService.deleteCategory(singleArgumentDTO.getValue());
        return categoryService.getAllCategoryDtoInfos();
    }


    @ResponseBody
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public Set<CategoryDTOInfo> getAllCategories() {
        return categoryService.getAllCategoryDtoInfos();
    }

}
