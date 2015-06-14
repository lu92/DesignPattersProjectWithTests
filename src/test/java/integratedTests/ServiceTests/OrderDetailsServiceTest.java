package integratedTests.ServiceTests;

import DesignPatternsProject.Neo4jTestApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
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
public class OrderDetailsServiceTest {

    @Test @Rollback(value = true)
    public void createOrder() {

    }

}
