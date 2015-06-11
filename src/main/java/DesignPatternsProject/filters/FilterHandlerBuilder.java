package DesignPatternsProject.filters;

import DesignPatternsProject.entities.actors.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by lucjan on 04.06.15.
 */
public class FilterHandlerBuilder {
    private FilterHandler filterManager;

    public FilterHandlerBuilder() {
        filterManager = new FilterHandler();
    }

    public FilterHandlerBuilder(Set<Person> allPersons) {
        filterManager = new FilterHandler(allPersons);
    }


    public List<PersonCriteria> getCriterias() {
        List<PersonCriteria> objectCriteriaList = new ArrayList<>();
        PersonCriteria objectCriteria = filterManager.getBegin();
        while(objectCriteria != null) {
            objectCriteriaList.add(objectCriteria);
            objectCriteria = objectCriteria.getNext();
        }
        return objectCriteriaList;
    }

    public void addCriteria(PersonCriteria... objectCriterias) {
        if (filterManager.getBegin() == null && objectCriterias.length > 0) {
            PersonCriteria objectCriteria = filterManager.getBegin();
            filterManager.setBegin(objectCriterias[0]);
            objectCriteria = filterManager.getBegin();
            for (int i= 1; i<objectCriterias.length; i++) {
                objectCriteria.setNext(objectCriterias[i]);
                objectCriteria = objectCriteria.getNext();
            }
//            objectCriterias[objectCriterias.length-1].setNext(new NullCriteria());
        }
        else {

            PersonCriteria objectCriteria = filterManager.getBegin();
            while (objectCriteria.getNext() != null )
                objectCriteria = objectCriteria.getNext();

//            objectCriteria.setNext(null);

            for (PersonCriteria criteria : objectCriterias) {
                objectCriteria.setNext(criteria);
                objectCriteria = objectCriteria.getNext();
            }

//            objectCriteria.setNext(new NullCriteria());
        }
    }

    public void removeCriteria(PersonCriteria criteriaToRemove) {
        PersonCriteria criteria = filterManager.getBegin();
        PersonCriteria prev = null;

        while (criteria != null && criteria != criteriaToRemove) {
            prev = criteria;
            criteria = criteria.getNext();
        }

        if (criteria != null) {
            if (prev == null)
                criteria.setNext(criteria.getNext());
            else
                prev.setNext(criteria.getNext());
        }
    }


    public int getNumberOfCriterias() {
        int number = 0;
        PersonCriteria objectCriteria = filterManager.getBegin();
        while(objectCriteria != null) {
            number++;
            objectCriteria = objectCriteria.getNext();
        }
        return number;
    }

    public FilterHandler getBuiltResult() {
        return filterManager;
    }

}
