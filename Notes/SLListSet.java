import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SLListSet<T> implements Iterable<T> {
    private List<T> items;
    public SLListSet(){items = new LinkedList<>();}
    public boolean contains(T value){return items.contains(value);}
    public int size(){return items.size();}
    public void add(T value){if(!items.contains(value)){items.add(value);}}

    private class SLListSetIterator implements Iterator<T> {
        private int itPos; //track
        public SLListSetIterator(){itPos = 0;}
        @Override
        public boolean hasNext() { return itPos < items.size(); }
        @Override
        public T next() {
            T toReturn = items.get(itPos);
            itPos++;
            return toReturn;
        }
    }
    public Iterator<T> iterator(){return new SLListSetIterator();}
    public boolean equals(Object o){
        if(o==null||this.getClass()!=o.getClass()){return false;};
        if(this==o){return true;}
        SLListSet<T> other = (SLListSet<T>) o;
        if(this.size()!=other.size()){return false;}
        for(int i=0;i<items.size();i++){
            if(other.items.get(i)!=this.items.get(i)){return false;}
        }
        return true;
    }
    public static void main(String[] args) {
/*
        SLListSet<Integer> a = new SLListSet<>();
        a.add(23);
        a.add(11);
        SLListSet<Integer> b = new SLListSet<>();
        b.add(23);
        b.add(11);
        System.out.println("FOR A:");
        System.out.println(a.equals(b));
        for (int i:a){
            System.out.println(i);
        }
        System.out.println("FOR B:");
        System.out.println(b.equals(a));
        for (int i:b){
            System.out.println(i);
        }
 */
    }
}



