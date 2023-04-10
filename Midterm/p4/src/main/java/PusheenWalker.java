import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

public class PusheenWalker<T> implements Iterable<T> {
    List<T> tb;
    public PusheenWalker(List<List<T>> tb) {
        List<T> t = new LinkedList<>();
        int i = 0;
        while (i<tb.size()){
           int j =0;
           while (j<tb.get(i).size()){
               t.add(tb.get(i).get(j));
           }
        }
        this.tb = t;
    }
    private class PusheenWalkerIter implements Iterator<T> {
        private int P;
        public PusheenWalkerIter() {P=0;}
        @Override
        public boolean hasNext() { return P < tb.size(); }
        @Override
        public T next() {
            T toReturn = tb.get(P);
            P++;
            return toReturn;
        }
    }
    public Iterator<T> iterator() {return new PusheenWalkerIter();}
}
