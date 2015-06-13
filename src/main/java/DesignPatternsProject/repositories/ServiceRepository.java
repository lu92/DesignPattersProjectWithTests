package DesignPatternsProject.repositories;

import DesignPatternsProject.entities.productsAndServices.Service;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by lucjan on 13.06.15.
 */
public interface ServiceRepository extends GraphRepository<Service> {
}
