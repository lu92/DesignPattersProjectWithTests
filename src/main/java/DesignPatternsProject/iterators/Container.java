package DesignPatternsProject.iterators;

/**
 * Created by lucjan on 29.04.15.
 */
public interface Container<T> {
    public void add(T object);
    public void remove(T object);
    public T get(int index);
    public void clear();
    public boolean isEmpty();
    public Iterator getIterator();
}
