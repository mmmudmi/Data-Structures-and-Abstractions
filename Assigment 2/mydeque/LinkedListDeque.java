public class LinkedListDeque<T> {
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
    public static void main(String[] args) {
    }
}

