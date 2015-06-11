package DesignPatternsProject.filters;

import java.util.Set;

/**
 * Created by lucjan on 06.06.15.
 */
public class ObjectCriteria<V> implements Filter<V> {

    private ObjectCriteria<V> next;

    public ObjectCriteria() {
    }

    public ObjectCriteria(ObjectCriteria next) {
        this.next = next;
    }

    @Override
    public Set<V> performFilter(Set<V> allObjects) {
        return null;
    }

    @Override
    public Set<V> doCriteriaFilter(Set<V> allObjects) {
        if (getNext() == null)
            return performFilter(allObjects);
        else
            return getNext().doCriteriaFilter(performFilter(allObjects));
    }

    public ObjectCriteria getNext() {
        return next;
    }

    public void setNext(ObjectCriteria next) {
        this.next = next;
    }
}
