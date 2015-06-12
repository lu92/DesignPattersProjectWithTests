package DesignPatternsProject.repositories;

import DesignPatternsProject.strategies.Country;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by lucjan on 13.06.15.
 */
public interface CountryRepository extends GraphRepository<Country> {
}
