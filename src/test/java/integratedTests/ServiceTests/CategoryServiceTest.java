package integratedTests.ServiceTests;

import DesignPatternsProject.DTO.CategoryFormDTO;
import DesignPatternsProject.Neo4jTestApplication;
import DesignPatternsProject.services.CategoryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lucjan on 14.06.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Neo4jTestApplication.class)
@Transactional
public class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;


    @Test @Rollback(value = true)
    public void createCategoryTest() {
        Assert.assertNotNull(categoryService);
        CategoryFormDTO categoryFormDTO = new CategoryFormDTO("komputery");
        categoryService.createCategory(categoryFormDTO);
        Assert.assertEquals(1, categoryService.getNumberOfCategories());
    }

    @Test @Rollback(value = true)
    public void deleteCategoryTest() {
        Assert.assertNotNull(categoryService);
        CategoryFormDTO categoryFormDTO = new CategoryFormDTO("komputery");
        long newCategoryId = categoryService.createCategory(categoryFormDTO).getCategory_id();
        Assert.assertEquals(1, categoryService.getNumberOfCategories());

        categoryService.deleteCategory(newCategoryId);
        Assert.assertEquals(0, categoryService.getNumberOfCategories());

    }

    @Test @Rollback(value = true)
    public void createCategoryAndAddBaseProductsTest() {
        Assert.assertNotNull(categoryService);
        CategoryFormDTO categoryFormDTO = new CategoryFormDTO("komputery");
        categoryService.createCategory(categoryFormDTO);
        Assert.assertEquals(1, categoryService.getNumberOfCategories());



    }


}
