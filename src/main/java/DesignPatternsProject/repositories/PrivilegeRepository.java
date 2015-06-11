package DesignPatternsProject.repositories;

import DesignPatternsProject.entities.personalData.Privilege;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by lucjan on 08.06.15.
 */
public interface PrivilegeRepository extends GraphRepository<Privilege> {
}
