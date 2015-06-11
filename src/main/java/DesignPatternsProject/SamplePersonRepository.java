package DesignPatternsProject;

/**
 * Created by lucjan on 14.05.15.
 */
import org.springframework.data.neo4j.repository.GraphRepository;

public interface SamplePersonRepository extends GraphRepository<Person> {

    Person findByName(String name);

    Iterable<Person> findByTeammatesName(String name);

}
