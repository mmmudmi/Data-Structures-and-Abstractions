public interface Deque<T>{
    void addFirst(T item);
    void addLast(T item);
    boolean isEmpty();
    int size();
    String toString();
    T removeFirst();
    T removeLast();
    T get(int index);
}
//TODO: Where to put @Override ?????
class LinkedListDeque<T> implements Deque<T>{
    private static class IntNode<T>  {
        T head;
        IntNode<T>  next;
        public IntNode(T head, IntNode<T>  next) {
            this.head = head;
            this.next = next;
        }
    }
    private IntNode<T>  sen;
    private int size;
    public LinkedListDeque(LinkedListDeque<T> other){
        this.sen = new IntNode<T> (null,null); size=0;
        if(other.size!=0){
            IntNode<T> p = this.sen;
            for(int i=0;i<other.size;i++,size++){
                p.next = new IntNode<T> (other.get(i),p.next);
                p = p.next;
            }
        }
    }
    public LinkedListDeque(){this.sen = new IntNode<T> (null,null); size=0;}
    public void addFirst(T item){this.sen.next = new IntNode<T> (item,sen.next); size ++;}
    public void addLast(T item){
        IntNode<T>  p = sen;
        while(p.next!=null){p=p.next;}
        p.next = new IntNode<T> (item,null);
        this.size ++;
    }
    public boolean isEmpty(){return this.sen.next==null;}
    public int size(){return this.size;}
    public String toString(){
        IntNode<T>  p = sen;
        String a = "";
        if(this.isEmpty()){return null;}
        else{
            a = ""+p.next.head;
            p = p.next;
            while (p.next!=null){a=a+" "+""+p.next.head;p=p.next;}
        }
        return a;
    }
    public T removeFirst(){
        T a ;
        IntNode<T>  p = sen;
        if(this.size != 0) {
            a = p.next.head;
            p.next = p.next.next;
            this.size --;
            return a;
        }
        else {return null;}
    }
    public T removeLast(){
        T a ;
        IntNode<T>  p = sen;
        if(this.isEmpty()){return null;}
        else {
            while (p.next.next != null) {
                p = p.next;
            }
            a = p.next.head;
            p.next = null;
            size--;
        }
        return a;
    }
    public T get(int index){
        T ans;
        IntNode<T>  p = sen;
        if(index<this.size){
            for(int i=0;i<index;i++){
                p = p.next;
            }
            return p.next.head;
        }
        return null;
    }
}
class ArrayDeque<T> implements Deque<T>{
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
}