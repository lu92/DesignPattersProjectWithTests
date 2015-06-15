package DesignPatternsProject;


import DesignPatternsProject.entities.actors.*;
import DesignPatternsProject.entities.actors.Person;
import DesignPatternsProject.entities.personalData.Role;
import DesignPatternsProject.entities.productsAndServices.BaseProduct;
import DesignPatternsProject.entities.productsAndServices.Category;
import DesignPatternsProject.repositories.*;
import DesignPatternsProject.resources.*;
import org.neo4j.graphdb.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.neo4j.core.GraphDatabase;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.logging.Logger;


@SpringBootApplication
public class Neo4jTestApplication implements CommandLineRunner {

    private Logger logger = Logger.getLogger(String.valueOf(this));

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private BaseProductRepository baseProductRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    GraphDatabase graphDatabase;


    @Transactional
    public static void main(String[] args) throws IOException {

        SpringApplication.run(Neo4jTestApplication.class, args);
        System.out.println("Hello world");
    }


    @Override
    @Transactional
    public void run(String... strings) throws Exception {

        Transaction tx = graphDatabase.beginTx();
        try {

//            categoryRepository.deleteAll();
            clientRepository.deleteAll();
//            baseProductRepository.deleteAll();
            personRepository.deleteAll();

//            Person persAdmin = new Admin("admin", "admin", "admin@gmail.com");
//            persAdmin.setPersonType(PersonType.ADMIN);

//            personRepository.save(persAdmin);

            for (DesignPatternsProject.entities.actors.Person person : PersonResource.getAllPersonsFromResources()) {
                Person personDB = personRepository.save(person);
                logger.info("new person " + personDB);
            }

//            categoryRepository.save(CategoryResources.getConsultingCategory());
//            categoryRepository.save(CategoryResources.getImplementationCategory());
//            categoryRepository.save(CategoryResources.getSecureCategory());
//
//
//            for (BaseProduct baseProduct :BaseProductResource.getAllBaseProducts()) {
//                baseProductRepository.save(baseProduct);
//            }

            clientRepository.save(ClientResource.getAnnaNowak());
            clientRepository.save(ClientResource.getPiotrKraus());

//            for (Role role : RoleResource.getAllRoles()) {
//                Role  roleDB = roleRepository.save(role);
//                logger.info("new role " + roleDB);
//            }
//



            tx.success();
        } finally {
            tx.close();
        }

    }
}
