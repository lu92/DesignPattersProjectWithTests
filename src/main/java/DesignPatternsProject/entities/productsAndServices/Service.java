package DesignPatternsProject.entities.productsAndServices;

import DesignPatternsProject.entities.actors.Worker;


/**
 * Created by lucjan on 10.03.15.
 */
public class Service extends BaseProduct{
    private Worker worker;

    public Service() {
    }

    public Service(String name, double netto) {
        super(name, netto);
    }

    public Service(String name, double netto, Category category) {
        super(name, netto, category);
    }

    public Service(Long id, String name, double netto) {
        super(id, name, netto);
    }

    public Service(Long id, String name, double netto, Category category) {
        super(id, name, netto, category);
    }

    public Service(Worker worker) {
        this.worker = worker;
    }

    public Service(String name, double netto, Worker worker) {
        super(name, netto);
        this.worker = worker;
    }

    public Service(String name, double netto, Category category, Worker worker) {
        super(name, netto, category);
        this.worker = worker;
    }

    public Service(Long id, String name, double netto, Worker worker) {
        super(id, name, netto);
        this.worker = worker;
    }

    public Service(Long id, String name, double netto, Category category, Worker worker) {
        super(id, name, netto, category);
        this.worker = worker;
    }
}
