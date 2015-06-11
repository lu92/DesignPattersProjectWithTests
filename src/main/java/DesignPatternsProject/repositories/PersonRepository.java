package DesignPatternsProject.repositories;

import DesignPatternsProject.entities.actors.Person;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by lucjan on 08.06.15.
 */
public interface PersonRepository extends GraphRepository<Person>{
    Person findByUsernameAndPassword(String username, String password);
}
