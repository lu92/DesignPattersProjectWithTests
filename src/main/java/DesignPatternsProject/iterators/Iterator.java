package DesignPatternsProject.iterators;

/**
 * Created by lucjan on 29.04.15.
 */
public interface Iterator<T> {
    public boolean hasNext();
    public T next();
    public void backToBegin();
}
