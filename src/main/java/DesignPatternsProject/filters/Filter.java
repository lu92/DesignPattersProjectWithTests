package DesignPatternsProject.filters;


import java.util.Set;

/**
 * Created by lucjan on 06.06.15.
 */
public interface Filter <V>{
    public abstract Set<V> performFilter(Set<V> allObjects);
    public Set<V> doCriteriaFilter(Set<V> allObjects);
}
