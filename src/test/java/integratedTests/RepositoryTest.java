package integratedTests;

import DesignPatternsProject.Neo4jTestApplication;
import DesignPatternsProject.entities.productsAndServices.BaseProduct;
import DesignPatternsProject.repositories.BaseProductRepository;
import DesignPatternsProject.repositories.ProductRepository;
import DesignPatternsProject.repositories.ServiceRepository;
import DesignPatternsProject.resources.BaseProductResource;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by lucjan on 13.06.15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Neo4jTestApplication.class)
@Transactional()
public class RepositoryTest {

    @Autowired
    private BaseProductRepository baseProductRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ServiceRepository serviceRepository;

    @Before
    public void init() {
        baseProductRepository.deleteAll();
    }

    @Test @Rollback(value = true)
    public void test1(){
        baseProductRepository.save(BaseProductResource.getAlgorithmLibrary());
        Assert.assertEquals(1, baseProductRepository.count());
        Assert.assertEquals(1, productRepository.count());
        Assert.assertEquals(0, serviceRepository.count());
    }

    @Test @Rollback(value = true)
    public void test2(){
        baseProductRepository.save(BaseProductResource.getConsulting());
        Assert.assertEquals(1, baseProductRepository.count());
        Assert.assertEquals(0, productRepository.count());
        Assert.assertEquals(1, serviceRepository.count());
    }

}
