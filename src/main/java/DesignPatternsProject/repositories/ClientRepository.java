package DesignPatternsProject.repositories;

import DesignPatternsProject.entities.actors.Client;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by lucjan on 12.06.15.
 */
public interface ClientRepository extends GraphRepository<Client> {
}
