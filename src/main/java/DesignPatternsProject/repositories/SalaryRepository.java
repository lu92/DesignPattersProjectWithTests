package DesignPatternsProject.repositories;

import DesignPatternsProject.entities.personalData.Salary;
import org.springframework.data.neo4j.repository.GraphRepository;

/**
 * Created by lucjan on 12.06.15.
 */
public interface SalaryRepository extends GraphRepository<Salary> {
}
