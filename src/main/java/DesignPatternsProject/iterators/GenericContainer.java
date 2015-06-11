package DesignPatternsProject.iterators;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lucjan on 29.04.15.
 */
public class GenericContainer<T> implements Container<T> {

    private List<T> repository = new ArrayList<>();


    @Override
    public void add(T object) {
        repository.add(object);
    }

    @Override
    public void remove(T object) {
        repository.remove(object);
    }

    @Override
    public T get(int index) {
        return repository.get(index);
    }

    @Override
    public void clear() {
        repository.clear();
    }

    @Override
    public boolean isEmpty() {
        return repository.isEmpty();
    }

    @Override
    public Iterator getIterator() {
        return null;
    }

    private class MyIterator<T> implements Iterator<T> {

        int index;

        @Override
        public boolean hasNext() {

            if(index < repository.size()){
                return true;
            }
            return false;
        }

        @Override
        public T next() {

            if(this.hasNext()){
                return (T) repository.get(index++);
            }
            return null;
        }

        @Override
        public void backToBegin() {
            index = 0;
        }
    }

}
