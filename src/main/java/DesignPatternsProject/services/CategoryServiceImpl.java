package DesignPatternsProject.services;

import DesignPatternsProject.DTO.CategoryDTOInfo;
import DesignPatternsProject.DTO.CategoryFormDTO;
import DesignPatternsProject.DTO.DTOConverter;
import DesignPatternsProject.entities.productsAndServices.BaseProduct;
import DesignPatternsProject.entities.productsAndServices.Category;
import DesignPatternsProject.repositories.BaseProductRepository;
import DesignPatternsProject.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucjan on 13.06.15.
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BaseProductRepository baseProductRepository;

    @Override
    public Category createCategory(CategoryFormDTO categoryFormDTO) {
        return categoryRepository.save(DTOConverter.toCategory(categoryFormDTO));
    }

    @Override
    public void deleteCategory(long id) {
        categoryRepository.delete(id);
    }

    @Override
    public Set<CategoryDTOInfo> getAllCategoryDtoInfos() {
        Set<CategoryDTOInfo> categoryDTOInfoSet = new HashSet<>();
        for (Category category : categoryRepository.findAll())
            categoryDTOInfoSet.add(DTOConverter.toCategoryDTOInfo(category));
        return categoryDTOInfoSet;
    }

    @Override
    public boolean addBaseProductToCategory(long baseProductId, long categoryId) throws IllegalArgumentException{
        BaseProduct baseProduct = null;
        Category category = null;

        try {
            baseProduct = baseProductRepository.findOne(baseProductId);
        } catch (Exception e) {
            throw new IllegalArgumentException("cannot find baseProduct with id " + baseProductId);
        }

        try {
            category = categoryRepository.findOne(categoryId);
        } catch (Exception e) {
            throw new IllegalArgumentException("cannot find category with id " + categoryId);
        }

        category.addProducts(baseProduct);
        categoryRepository.save(category);
        return true;
    }

    @Override
    public long getNumberOfCategories() {
        return categoryRepository.count();
    }

    @Override
    public Category getCategory(long id) {
        return categoryRepository.findOne(id);
    }
}
