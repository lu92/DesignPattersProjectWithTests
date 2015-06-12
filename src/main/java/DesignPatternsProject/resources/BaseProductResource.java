package DesignPatternsProject.resources;

import DesignPatternsProject.Person;
import DesignPatternsProject.entities.actors.Worker;
import DesignPatternsProject.entities.productsAndServices.BaseProduct;
import DesignPatternsProject.entities.productsAndServices.Product;
import DesignPatternsProject.entities.productsAndServices.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lucjan on 06.06.15.
 */
public class BaseProductResource {

    public static Product getCRM() {
        Product product = new Product("System CRM", 120 * 1000);
        return product;
    }

    public static Product getERP() {
        Product product = new Product("System ERP", 200 * 1000);
        return product;
    }

    public static Product getAlgorithmLibrary() {
        Product product = new Product("Algorithm Library", 300 * 1000);
        return product;
    }

    public static Product getSystemSecure() {
        Product product = new Product("System Secury", 700 * 1000);
        return product;
    }

    public static Product getMultiThreadingAlgorithmLibrary() {
        Product product = new Product("Algorithm Library", 1000 * 1000);
        return product;
    }

    public static Service getConsulting() {
        Service service  = new Service("Consulting", 2 * 1000, PersonResource.getJavaDeveloperWojciechSeliga());
        return service;
    }

    public static Service getImplemetationSystemCRM() {
        Service service  = new Service("Implementation System CRM", 20 * 1000, (Worker) PersonResource.getDatabaseDeveloperAdrianKrawiec());
        return service;
    }

    public static Service getImplementationSystemERP() {
        Service service  = new Service("Implementation System ERP", 25 * 1000, (Worker) PersonResource.getJavaDeveloperAdamWojcik());
        return service;
    }


    public static Set<BaseProduct> getAllBaseProducts() {
        Set<BaseProduct> allBaseProducts = new HashSet<>();
        allBaseProducts.add(getCRM());
        allBaseProducts.add(getERP());
        allBaseProducts.add(getAlgorithmLibrary());
        allBaseProducts.add(getSystemSecure());
        allBaseProducts.add(getConsulting());
        allBaseProducts.add(getImplemetationSystemCRM());
        allBaseProducts.add(getImplementationSystemERP());
        return allBaseProducts;
    }



}
