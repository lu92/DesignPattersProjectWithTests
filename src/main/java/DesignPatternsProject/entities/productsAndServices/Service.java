package DesignPatternsProject.entities.productsAndServices;

import DesignPatternsProject.entities.actors.Person;
import org.neo4j.graphdb.Direction;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.RelatedTo;


/**
 * Created by lucjan on 10.03.15.
 */
public class Service extends BaseProduct{

    @Fetch
    @RelatedTo(type = "PERSON_SERVICE", direction = Direction.BOTH)
    private Person worker;

    public Service() {
    }


    public Service(String name, double netto) throws IllegalArgumentException {
        super(name, netto);
    }

    public Service(String name, double netto, Category category) throws IllegalArgumentException {
        super(name, netto, category);
    }

    public Service(String name, double netto, Person worker) throws IllegalArgumentException{
        super(name, netto);
        if (worker == null)
            throw new IllegalArgumentException("worker can't be null");
        else
            this.worker = worker;
    }



    public Person getWorker() {
        return worker;
    }

    public void setWorker(Person worker) {
        this.worker = worker;
    }

    @Override
    public String toString() {
        return "Service{" +
                "worker=" + worker +
                "} " + super.toString();
    }
}
