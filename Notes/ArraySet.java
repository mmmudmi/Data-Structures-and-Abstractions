import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
public class ArraySet<T> implements Iterable<T> {
    private List<T> items;
    public ArraySet(){items = new ArrayList<>();}
    public boolean contains(T value){return items.contains(value);}
    public void add(T value){
        if(!items.contains(value)){items.add(value);}
    }
    public int size(){return items.size();}

    //inner class implementing Iterator
    private class ArraySetIterator implements Iterator<T> {
        private int itPos; // Track where the iterator currently is
        public ArraySetIterator(){itPos = 0;}
        @Override
        public boolean hasNext() { return itPos < items.size(); }

        public T next() {
            T toReturn = items.get(itPos);
            itPos++;
            return toReturn;
        }
    }
    //another inside class// call this to iterate
    public Iterator<T> iterator(){return  new ArraySetIterator();}

    public static void main(String[] args) {
        ArraySet<Integer> as = new ArraySet<>();
        as.add(1);
        as.add(5);
        as.add(1);
        as.add(3);
        for(int i: as){
            System.out.println(i);
        }
    }
}


/*
interface Iterable<E> {
    Iterator<E> iterator();
}
interface Iterator<T> {
    boolean hasNext();
    T next();
}

 */

