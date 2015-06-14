package DesignPatternsProject;


import DesignPatternsProject.entities.actors.*;
import DesignPatternsProject.entities.actors.Person;
import DesignPatternsProject.entities.personalData.Role;
import DesignPatternsProject.repositories.BaseProductRepository;
import DesignPatternsProject.repositories.CategoryRepository;
import DesignPatternsProject.repositories.PersonRepository;
import DesignPatternsProject.repositories.RoleRepository;
import DesignPatternsProject.resources.PersonResource;
import DesignPatternsProject.resources.RoleResource;
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

            for (Role role : RoleResource.getAllRoles()) {
                Role  roleDB = roleRepository.save(role);
                logger.info("new role " + roleDB);
            }

            for (DesignPatternsProject.entities.actors.Person person : PersonResource.getAllPersonsFromResources()) {
                Person personDB = personRepository.save(person);
                logger.info("new person " + personDB);
            }


            tx.success();
        } finally {
            tx.close();
        }

    }
}
