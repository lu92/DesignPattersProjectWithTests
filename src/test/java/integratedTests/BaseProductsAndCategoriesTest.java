package integratedTests;

import DesignPatternsProject.Neo4jTestApplication;
import DesignPatternsProject.entities.actors.Worker;
import DesignPatternsProject.entities.productsAndServices.BaseProduct;
import DesignPatternsProject.entities.productsAndServices.Category;
import DesignPatternsProject.entities.productsAndServices.Product;
import DesignPatternsProject.entities.productsAndServices.Service;
import DesignPatternsProject.repositories.BaseProductRepository;
import DesignPatternsProject.repositories.CategoryRepository;
import DesignPatternsProject.repositories.PersonRepository;
import DesignPatternsProject.resources.CategoryResources;
import DesignPatternsProject.resources.PersonResource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lucjan on 12.06.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Neo4jTestApplication.class)
@Transactional
public class BaseProductsAndCategoriesTest {

    @Autowired
    private BaseProductRepository baseProductRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void f() {
    }

    @Test @Rollback(true)
    public void saveCategory() {

        Assert.assertNotNull(baseProductRepository);
        Assert.assertNotNull(categoryRepository);
        Assert.assertNotNull(personRepository);

        personRepository.deleteAll();
        categoryRepository.deleteAll();
        baseProductRepository.deleteAll();

        personRepository.save(PersonResource.getJavaDeveloperWojciechSeliga());
        Assert.assertEquals(1, personRepository.count());

        Category category = new Category("Consulting new");
        category.addProducts(new Product("margaryna", 3.5));
        category.addProducts(new Service("sprzatanie", 100, PersonResource.getJavaDeveloperWojciechSeliga()));
        category.addProducts(new Service("sprzatanie", 100, PersonResource.getJavaDeveloperWojciechSeliga()));
        categoryRepository.save(category);
        for (BaseProduct baseProduct : baseProductRepository.findAll())
            System.out.println(baseProduct);
        Assert.assertEquals(2, baseProductRepository.count());
        Assert.assertEquals(1, categoryRepository.count());
        baseProductRepository.deleteAll();
    }

//
//
//
    @Test @Rollback(true)
    public void saveTreeBaseProducts() {
        baseProductRepository.deleteAll();
        baseProductRepository.save(new Product("maslo", 3.5));
        baseProductRepository.save(new Product("mleko", 3));

//        personRepository.save((Worker) PersonResource.getJavaDeveloperWojciechSeliga());
//        Assert.assertEquals(1, personRepository.count());

        baseProductRepository.save(new Service("fryzjer", 50.0));

        Assert.assertEquals(3, baseProductRepository.count());

        for (BaseProduct baseProduct : baseProductRepository.findAll())
            System.out.println(baseProduct);

//        Assert.assertEquals(1, categoryRepository.count());
        baseProductRepository.deleteAll();
    }

    @Test @Rollback(true)
    public void savePreparedCategory() {
        personRepository.deleteAll();
        personRepository.save(PersonResource.getJavaDeveloperWojciechSeliga());
        Assert.assertEquals(1, personRepository.count());

        categoryRepository.deleteAll();
        categoryRepository.save(CategoryResources.getConsultingCategory());

        for (Category category : categoryRepository.findAll())
            System.out.println(category);

        Assert.assertEquals(1, categoryRepository.count());
        baseProductRepository.deleteAll();
    }

}
