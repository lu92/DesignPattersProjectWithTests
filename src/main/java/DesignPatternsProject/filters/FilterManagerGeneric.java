package DesignPatternsProject.filters;

import java.util.Set;

/**
 * Created by lucjan on 06.06.15.
 */
public class FilterManagerGeneric <T, E extends Filter> {
//    T - type
//    E - Element

    private E begin;
    private Set<E> allObjects;

    public FilterManagerGeneric() {
    }

    public FilterManagerGeneric(Set<E> allObjects) {
        this.allObjects = allObjects;
    }

    public Set<E> doFilter() {
        return begin.doCriteriaFilter(allObjects);
    }

    public E getBegin() {
        return begin;
    }

    public void setBegin(E begin) {
        this.begin = begin;
    }
}
