import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MyPriorityQueue<T> implements IPriorityQueue<T> {
    private List<T> queueItems;
    private CompareWith<T> queueItem;
    private int size;
    public MyPriorityQueue(CompareWith<T> cc) {
        this.queueItems = new ArrayList<>();
        this.queueItem = cc;
        size=0;
    }
    @Override
    public void add(T item) {
        if(size==0){queueItems.add(item);}
        else {
            for(int i = 0;i<size;i++){
                if (queueItem.lessThan(item,queueItems.get(i))){
                    queueItems.add(i,item);
                    break;
                }
                else if(queueItems.get(i)==item){
                    queueItems.add(i,item);
                    break;
                }
                else if(i==size-1){
                    queueItems.add(item);
                }
            }
        }
        size++;
    }

    @Override
    public void addAll(List<T> items) {
        for (T i : items){add(i);}
    }

    @Override
    public T getMinimum() {return queueItems.get(0);}

    @Override
    public void removeMinimum() {queueItems.remove(0);size--;}

    @Override
    public int size() {return size;}
//small to large
    @Override
    public Iterator<T> iterator() { return new MyPriorityQueueIter();}
//large to small
    @Override
    public Iterator<T> revIterator() {
        return new BMyPriorityQueueIter();
    }

    private class MyPriorityQueueIter implements Iterator<T> {
        private int itPos;
        public MyPriorityQueueIter(){itPos = 0;}
        @Override
        public boolean hasNext() { return itPos < queueItems.size(); }
        @Override
        public T next() {
            T toReturn = queueItems.get(itPos);
            itPos++;
            return toReturn;
        }
    }
    private class BMyPriorityQueueIter implements Iterator<T> {
        private int itPos;
        public BMyPriorityQueueIter(){itPos = queueItems.size()-1;}
        @Override
        public boolean hasNext() { return itPos >= 0; }
        @Override
        public T next() {
            T toReturn = queueItems.get(itPos);
            itPos--;
            return toReturn;
        }
    }

}
