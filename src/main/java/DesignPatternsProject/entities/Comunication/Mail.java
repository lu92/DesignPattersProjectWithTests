package DesignPatternsProject.entities.Comunication;

import DesignPatternsProject.entities.actors.Person;
import org.springframework.data.annotation.Transient;
import org.springframework.data.neo4j.annotation.*;

/**
 * Created by lucjan on 10.03.15.
 */
@RelationshipEntity(type = "MAIL_TO")
public class Mail {

    @GraphId
    private Long Id;

    @Fetch @StartNode
    private Person from;

    @Fetch @EndNode
    private Person to;

    private String title;
    private String message;

    public Mail() {
    }


    public Mail(Person from, Person to, String title, String message) {
        this.from = from;
        this.to = to;
        this.title = title;
        this.message = message;
    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Person getFrom() {
        return from;
    }

    public void setFrom(Person from) {
        this.from = from;
    }

    public Person getTo() {
        return to;
    }

    public void setTo(Person to) {
        this.to = to;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
