package DesignPatternsProject.repositories;

import DesignPatternsProject.entities.orders.AbstractOrderDetails;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by lucjan on 12.06.15.
 */
public interface OrderDetailsRepository extends GraphRepository<AbstractOrderDetails> {
}
