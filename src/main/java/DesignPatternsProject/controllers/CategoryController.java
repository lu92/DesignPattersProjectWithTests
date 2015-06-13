package DesignPatternsProject.controllers;

import DesignPatternsProject.DTO.CategoryDTOInfo;
import DesignPatternsProject.DTO.CategoryFormDTO;
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
    public Category createCategory(@RequestBody CategoryFormDTO categoryFormDTO) {
        return categoryService.createCategory(categoryFormDTO);
    }

    @ResponseBody
    @RequestMapping(value = "/delete/{categoryId}", method = RequestMethod.DELETE)
    public void deleteCategory(@PathVariable("categoryId") long categoryId) {
        categoryService.deleteCategory(categoryId);
    }

    @ResponseBody
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public Set<CategoryDTOInfo> getAllCategories() {
        return categoryService.getAllCategoryDtoInfos();
    }

}
