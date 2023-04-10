public class SLList{
    public static void main(String[] args) {
        SLList L = new SLList(4);
        L.addFirst(3);
        L.addFirst(2);
        L.addFirst(1);
        L.insert(1000,4);
        System.out.println(L.toString());
        System.out.println(L.size());
        System.out.println(L.getLast());
    }
    private static class IntNode{
        int head;
        IntNode next;
        public IntNode(int head,IntNode next){
            this.head = head;
            this.next = next;
        }
    }
    private IntNode sentinel;
    private int size;

    public SLList() {
        sentinel = new IntNode(-99, null);
        size = 0;
    }
    //Exercise 0:
    public int size(){ return this.size;}

    public SLList(int x) {
        IntNode first = new IntNode(x, null);
        sentinel = new IntNode(-99, first);
        size = 1 ;
    }
    public void addFirst(int x){
        sentinel.next = new IntNode(x,sentinel.next);
        size+=1;
    }
    public int getFirst() { return sentinel.next.head; }

    public void addLast(int x) {
        size += 1;
        IntNode p = sentinel;
        while (p.next != null){
            p = p.next; //keep going till the last one on the list
        }
        p.next = new IntNode(x,null);
    }
    public int getLast() {
        IntNode  p = sentinel;
        int l = 0;
        if(this.size == 0) {return p.head;}
        while(p!=null){
            l = p.head;
            p = p.next;
        }
        return l;
    }
    //Exercise 1:
    public String toString(){
        IntNode p = sentinel.next;
        if(this.size==0){return null;};
        String ans = String.valueOf(p.head);
        while (p.next != null) {
            p = p.next; //keep going till the last one on the list
            ans = ans + ", " + String.valueOf(p.head);
        }
        return ans;
    }
    //exercise 2:
    public void removeFirst(){
        if(this.size != 0) {
            IntNode p = sentinel;
            p.next = p.next.next;
            size -= 1;
        }
    }
    public void insert(int newValue, int k){
        int count = 0;
        IntNode p = sentinel.next;
        while(count<=this.size){
            if (k == 0){this.addFirst(newValue); break;}
            else if (count == k-1){
                p.next = new IntNode(newValue,p.next);count++;
            }
            else{ p = p.next; count++;}
        }
        this.size++;
    }
}