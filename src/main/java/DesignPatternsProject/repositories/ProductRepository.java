package DesignPatternsProject.repositories;

import DesignPatternsProject.entities.productsAndServices.Product;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by lucjan on 13.06.15.
 */
public interface ProductRepository extends GraphRepository<Product> {
}
