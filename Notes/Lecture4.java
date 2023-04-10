/*
class SLList{
    private static class IntNode{
        int head;
        IntNode next;
        public IntNode(int head,IntNode next){
            this.head = head;
            this.next = next;
        }
    }
    private IntNode first;
    private int size;

    public SLList() {
        //first = null;
        sentinel = new IntNode(-42,null);
        size = 0;}

    public int size(){return this.size;}

    public void addFirst(int x){
        //to stick x to the front of the list
        first = new IntNode(x,first);
        size += 1;
    }

    public int getFirst(){
        // return the element at the front of the list
//        return first.head;
        return sentinel.next.head; //sentinel
    }

    public void addLast(int x){
        IntNode p = first;
        if(first == null){//initially the list is empty
            first = new IntNode(x,null);

        }
        while(p.next != null){
            p = p.next;
        }
        // p is now the last node in the chain
        // attach a new node to p
        p.next = new IntNode(x,null);
        size += 1;
    }
}
*/