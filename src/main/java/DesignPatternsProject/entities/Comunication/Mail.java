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

    private boolean readed;

    public Mail() {
    }


    public Mail(Person from, Person to, String title, String message, boolean readed) {
        this.from = from;
        this.to = to;
        this.title = title;
        this.message = message;
        this.readed = readed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mail mail = (Mail) o;

        if (readed != mail.readed) return false;
        if (from != null ? !from.equals(mail.from) : mail.from != null) return false;
        if (message != null ? !message.equals(mail.message) : mail.message != null) return false;
        if (title != null ? !title.equals(mail.title) : mail.title != null) return false;
        if (to != null ? !to.equals(mail.to) : mail.to != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = from != null ? from.hashCode() : 0;
        result = 31 * result + (to != null ? to.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (readed ? 1 : 0);
        return result;
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

    public boolean isReaded() {
        return readed;
    }

    public void setReaded(boolean readed) {
        this.readed = readed;
    }
}

