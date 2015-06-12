package DesignPatternsProject.repositories;

import DesignPatternsProject.entities.productsAndServices.Category;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by lucjan on 12.06.15.
 */
public interface CategoryRepository extends GraphRepository<Category> {
}
