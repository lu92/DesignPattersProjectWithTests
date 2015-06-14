package DesignPatternsProject.services;

import DesignPatternsProject.DTO.CategoryDTOInfo;
import DesignPatternsProject.DTO.CategoryFormDTO;
import DesignPatternsProject.entities.productsAndServices.Category;

import java.util.Set;

/**
 * Created by lucjan on 13.06.15.
 */
public interface CategoryService {
    Category createCategory(CategoryFormDTO categoryFormDTO);
    void deleteCategory(long id);
    Set<CategoryDTOInfo> getAllCategoryDtoInfos();
    boolean addBaseProductToCategory(long baseProductId, long categoryId) throws IllegalArgumentException;
    long getNumberOfCategories();
    Category getCategory(long id);
}
