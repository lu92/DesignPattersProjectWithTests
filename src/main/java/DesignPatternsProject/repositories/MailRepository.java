package DesignPatternsProject.repositories;

import DesignPatternsProject.entities.Comunication.Mail;
import org.springframework.data.neo4j.repository.GraphRepository;

import java.util.Set;

/**
 * Created by lucjan on 13.06.15.
 */
public interface MailRepository extends GraphRepository<Mail> {
    Set<Mail> findByTitleAndMessage(String title, String message);
}
