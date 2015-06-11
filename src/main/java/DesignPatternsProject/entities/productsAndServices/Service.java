package DesignPatternsProject.entities.productsAndServices;

import DesignPatternsProject.entities.actors.Worker;


/**
 * Created by lucjan on 10.03.15.
 */
public class Service extends BaseProduct{
    private Worker worker;

    public Service() {
    }


    public Service(String name, double netto) throws IllegalArgumentException {
        super(name, netto);
    }

    public Service(String name, double netto, Category category) throws IllegalArgumentException {
        super(name, netto, category);
    }

    public Service(String name, double netto, Worker worker) throws IllegalArgumentException{
        super(name, netto);
        if (worker == null)
            throw new IllegalArgumentException("worker can't be null");
        else
            this.worker = worker;
    }

    public Worker getWorker() {
        return worker;
    }

    public void setWorker(Worker worker) {
        this.worker = worker;
    }
}
