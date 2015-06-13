package integratedTests.ServiceTests;

import DesignPatternsProject.DTO.ProductFormDTO;
import DesignPatternsProject.DTO.ServiceFormDTO;
import DesignPatternsProject.Neo4jTestApplication;
import DesignPatternsProject.entities.productsAndServices.Category;
import DesignPatternsProject.entities.productsAndServices.Product;
import DesignPatternsProject.entities.productsAndServices.Service;
import DesignPatternsProject.repositories.CategoryRepository;
import DesignPatternsProject.repositories.PersonRepository;
import DesignPatternsProject.resources.BaseProductResource;
import DesignPatternsProject.resources.CategoryResources;
import DesignPatternsProject.resources.PersonResource;
import DesignPatternsProject.services.BaseProductService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

/**
 * Created by lucjan on 13.06.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Neo4jTestApplication.class)
@Transactional
public class BaseProductServiceTest {

    @Autowired
    private BaseProductService baseProductService;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Before
    public void init() {
        baseProductService.deleteAll();
    }

    @Test @Rollback(value = true)
    public void insertService() {

        Category category = new Category("consulting");

        //  zapisanie i pobranie id kategorii
        long categoryId = categoryRepository.save(category).getCategory_id();

        //  zapisanie i pobranie id pracownika
        long workerId = personRepository.save(PersonResource.getManagerJanKowalski()).getId();

        ServiceFormDTO serviceFormDTO = new ServiceFormDTO("consulting and negotiations", 20 * 1000, categoryId, workerId);
        Service serviceDb = (Service) baseProductService.createService(serviceFormDTO);
        System.out.println(baseProductService.getAllServices());
        Assert.assertEquals(1, baseProductService.getNumberOfServices());
        Assert.assertTrue("czy zapisana usluga istnieje w bazie", baseProductService.getAllBaseProducts().contains(serviceDb));
    }

    @Test @Rollback(value = true)
    public void insertProduct() {

        Category category = new Category("implementation");

        //  zapisanie i pobranie id kategorii
        long categoryId = categoryRepository.save(category).getCategory_id();

        ProductFormDTO productFormDTO = new ProductFormDTO("system CRM", 200 * 1000, categoryId);

        Product productDB = (Product) baseProductService.createProduct(productFormDTO);
        Assert.assertEquals(1, baseProductService.getNumberOfProducts());
        Assert.assertTrue("czy zapisany produkt istnieje w bazie", baseProductService.getAllBaseProducts().contains(productDB));
    }


}
