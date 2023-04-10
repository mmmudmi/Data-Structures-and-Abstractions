package histogram;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SimpleHistogram<DT> implements Histogram<DT>, Iterable<DT> {
    DT[] items;
    public SimpleHistogram(){}
    public SimpleHistogram(DT items[]){this.items = items;}
    public SimpleHistogram(Histogram<DT> hist){
        for (DT i:hist){
            setCount(i,hist.getCount(i));
        }
    }
    public int getTotalCount(){return this.items.length;}
    public int size(){return items.length;}
    public int getCount(DT item){
        int count=0;
        int index = 0;
        while(index<items.length){
            if(items[index]==item){count++;index++;}
            else {index++;}
        }
        return count;
    }
    public void setCount(DT item, int count){
        if(getCount(item)==0){
            DT[] expandedItems = (DT[])new  Object[items.length+count];
            System.arraycopy(items,0,expandedItems,0,items.length);
            items = expandedItems;
            for (int j=items.length-count;j<items.length;j++){
                items[j] = item;
            }
        }
        else {
            for (DT i : items) {
                if (i == item && getCount(i) < count) {
                    int c = count - getCount(i);
                    DT[] expandedItems = (DT[]) new Object[items.length + c];
                    System.arraycopy(items, 0, expandedItems, 0, items.length);
                    items = expandedItems;
                    for (int j = items.length - c; j < items.length; j++) {
                        items[j] = item;
                    }
                } else if (i == item && getCount(i) > count) {
                    int c = getCount(i) - count;
                    int index = 0;
                    DT[] updatedItems = (DT[]) new Object[items.length - c - 1];
                    for (int j = 0; j < items.length; j++) {
                        if (items[j] != item) {
                            updatedItems[index] = items[j];
                            index++;
                        }
                    }
                    for (int h = items.length - c + 1; h < items.length; h++) {
                        updatedItems[h] = item;
                    }
                    items = updatedItems;
                }
            }
        }
    }
    public String toString(){
        if(items.length==0){return "";}
        String n = String.valueOf(items[0]);
        for(int i =1;i<items.length;i++ ){
            n = n + ", " + String.valueOf(items[i]);
        }
        return n;
    }
    public boolean equals(Object o){
        if(o==null||this.getClass()!=o.getClass()){return false;};
        if(this==o){return true;}
        SimpleHistogram<DT> other =  (SimpleHistogram<DT>) o;
        if(this.size()!=other.items.length){return false;}
        for(int i=0;i<items.length;i++){
            if(this.items[i]!=other.items[i]){return false;}
        }
        return true;
    }
    private class SimpleHistogramIter implements Iterator<DT> {
        private int itPos;
        private List<DT> l;
        public SimpleHistogramIter(){itPos = 0;l=new LinkedList<>();}
        @Override
        public boolean hasNext() {
            if(itPos < items.length){
                if(l.contains(items[itPos])){
                    if(itPos+skip()<items.length){itPos+=skip();return true;}
                    else if(itPos+skip()>=items.length) {return false;}
                }
                else {return true;}
            }
            return  false;
        }
        public int skip(){
            int count = 0;
            for (int i = itPos;i<items.length;i++){
                if(l.contains(items[i])){count++;}
            }
            return count;
        }
        @Override
        public DT next() {
            DT toReturn = items[itPos];
            itPos++;
            l.add(toReturn);
            return toReturn;
        }
    }
    public Iterator<DT> iterator(){return new SimpleHistogramIter();}
}

