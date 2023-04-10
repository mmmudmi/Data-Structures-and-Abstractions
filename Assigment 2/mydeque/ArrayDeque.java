public class ArrayDeque<T> {
    private T[] items;
    private int size;
    public ArrayDeque(){
        items = (T[])new Object[8];
        size = 0;
    }
    public ArrayDeque(ArrayDeque<T> other){
        items = (T[])new Object[other.size+1];
        size = other.size;
        for (int i =0;i<other.size;i++){
            items[i] = other.get(i);
        }
    }
    public void grow(int newCap){
        T[] expandedItems = (T[]) new Object[newCap];
        System.arraycopy(items,0,expandedItems,0,size);
        items = expandedItems;
    }
    public void shrink(){
        T[] shrunkItems = (T[]) new Object[size*2];
        System.arraycopy(items,0,shrunkItems,0,size);
        items = shrunkItems;
    }
    public void addFirst(T item){
        size++;
        if(size >= items.length){
            grow(size*2);
        }
        T old;
        for(int i=0;i<size;i++){
            items[i+1]=items[i];
        }
        items[0] = item;
        this.shrink();
    }
    public void addLast(T item){
        size++;
        if(size >= items.length){
            if(size==0){grow(20);}
            grow(size*2);}
        items[size-1] = item;
        this.shrink();
    }
    public boolean isEmpty(){return size==0;}
    public int size(){ return size;}
    public String toString(){
        if(this.isEmpty()){return null;}
        String ans = ""+items[0];
        for (int i=1;i<size;i++){
            ans= ans + " " + "" + items[i];
        }
        return ans;
    }
    public T removeFirst(){
        if(this.isEmpty()){return null;}
        size--;
        T ans = items[0];
        for (int i=0;i<size;i++){
            items[i] = items[i+1];
        }
        this.shrink();
        return ans;
    }
    public T removeLast(){
        if(this.isEmpty()){return null;}
        T ans = items[size-1];
        items[size-1]=null;
        size--;
        this.shrink();
        return ans;
    }
    public T get(int index){
        if(index>=size){return null;}
        return items[index];
    }
    public static void main(String[] args) {
    }
}
