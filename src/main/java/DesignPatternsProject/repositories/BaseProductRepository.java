package DesignPatternsProject.repositories;

import DesignPatternsProject.entities.productsAndServices.BaseProduct;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by lucjan on 12.06.15.
 */
public interface BaseProductRepository extends GraphRepository<BaseProduct> {
}
