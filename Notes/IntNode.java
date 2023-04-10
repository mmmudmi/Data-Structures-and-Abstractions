public class IntNode {
    int head;
    IntNode rest;
    public IntNode(int head, IntNode rest) {
        this.head = head;
        this.rest = rest;
    }
    public int size() {
        if (this.rest == null)
            return 1;
        else
            return 1 + this.rest.size();
    }
    public String iterativeToString(){
        IntNode current = this;
        String f = String.valueOf(current.head);
        int count = 0;
        current= current.rest;
        int size = current.size();
        while(count<size){
            f = f + ", " + String.valueOf(current.head) ;
            current = current.rest;
            count++;
        }
        return f;
    }
    public int get(int i) {
        IntNode current = this;
        int size = current.size();
        int[] n = new int[size];
        int c =0;
        while(current!=null && c<=size){
            n[c] = current.head;
            current = current.rest;
            c++;
        }
        return n[i];
    }

    public void set(int i, int newValue) {
        IntNode current = this;
        int size = current.size();
        int c =0;
        while(current!=null && c<=size){
            if(c==i){
                current.head = newValue;
            }
            current = current.rest;
            c++;
        }
    }
    public IntNode incrList(int delta) {
        if (this.rest == null)
            return new IntNode(this.head + delta, null);
        else
            return new IntNode(this.head + delta, this.rest.incrList(delta));
    }
/*
    public static void main(String[] args) {

        IntNode list0 = null;
        IntNode list1 = new IntNode(9,list0);
        IntNode list2 = new IntNode(11,list1);
        IntNode list3 = new IntNode(7,list2);

        System.out.println(list3.iterativeToString());
        list3.set(2,200);
        System.out.println(list3.iterativeToString());
        System.out.println(list3.get(1));
        System.out.println(list3.incrList(1000).iterativeToString());
        System.out.println(list3.iterativeToString());
    }
*/
}