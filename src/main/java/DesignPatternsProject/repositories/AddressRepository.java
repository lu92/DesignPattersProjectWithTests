package DesignPatternsProject.repositories;

import DesignPatternsProject.entities.personalData.Address;
import org.springframework.data.neo4j.repository.GraphRepository;
import java.util.Set;

/**
 * Created by lucjan on 08.06.15.
 */
public interface AddressRepository extends GraphRepository<Address> {
    Set<Address> findByCountry(String country);
    Set<Address> findByCity(String city);
    Set<Address> findByStreet(String street);
    Set<Address> findByCountryAndCity(String country, String city);
}
