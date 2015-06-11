package DesignPatternsProject.repositories;

import DesignPatternsProject.entities.personalData.Role;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by lucjan on 08.06.15.
 */
public interface RoleRepository extends GraphRepository<Role> {
    Role findByName(String name);
}
