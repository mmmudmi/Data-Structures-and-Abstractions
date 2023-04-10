public class AList <T> {
    public static void main(String[] args) {
    }
    private T[] items;
    private int size;
    public AList(){
        items = (T[]) new Object[1];
        size = 0;
    }
    public int size(){ return size;}
    public void addFirst(T x){
        for(int i =0;i<size;i++){
            if(size >= items.length){
                grow(2*size);
                items[i+1] = items[i];
            }
            items[i+1] = items[i];
        }
        items[0] = x;
        size++;
    }
    public T getFirst(){return items[0];}
    public void addLast(T x){
        if(size == items.length){ grow(2*size);}
        items[size] = x;
        size++;
    }
    public T getLast(){return items[size-1];}

    public String toString(){
        if(size==0){return "";}
        String n = String.valueOf(items[0]);
        for(int i =1;i<size;i++ ){
            n = n + ", " + String.valueOf(items[i]);
        }
        return n;
    }
    public void grow(int newCap){
        T[] expandedItems = (T[]) new Object[newCap];
        System.arraycopy(items,0,expandedItems,0,size);
        items = expandedItems;
    }
    public T removeLast() {
        T itemToRemove = items[size - 1];
        items[size - 1] = null; // important: see below
        size--;
        return itemToRemove;
    }
    public T removeFirst(){
        T itemToRemove = items[0];
        int i = 0;
        while (i<size){items[i]=items[i+1];i++;}
        size--;
        return itemToRemove;
    }
    public void insert(T newValue, int k){
        size++;
        T old = items[k];
        for(int i=k;i<=size+1;i++){
            if(i+1==items.length){ grow(2*size);}
            T wait = items[i+1];
            items[i+1] = old;
            old = wait;
        }
        items[k] = newValue;
    }
}
