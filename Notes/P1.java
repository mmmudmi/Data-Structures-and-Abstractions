import java.util.Arrays;
public class P1{
    public static void main(String[] args) {
        P1 a = new P1();
        a.addFirst(5);
        a.addFirst(5);
        a.addFirst(5);
        System.out.println(a.read());
        System.out.println(a.isEmpty());
    }
    private static class IntNode{
        int head;
        IntNode rest;

        public IntNode(int val, IntNode r){this.head=val;this.rest=r;}
    }
    private IntNode sen;
    public P1() {sen = new IntNode(0,null);}
    public int getFirst(){return sen.rest.head;}
    public boolean isEmpty(){return sen.rest == null;}
    public void addFirst(int x){sen.rest = new IntNode(x,sen.rest);}
    public double getAverage(){
        if(this.isEmpty()) {return 0.0;}
        else{
            IntNode p = sen.rest;
            double sum = p.head;
            p = p.rest;
            while (p!=null) {sum += p.head; p=p.rest;}
            int count = 0;
            IntNode q = sen.rest;
            while (q!=null){count++; q = q.rest;}
            return sum/count;
        }
    }
    public String read(){
        String n;
        IntNode p = sen.rest;
        if(this.isEmpty()){return "";}
        else {
            n = String.valueOf(p.head);
            p = p.rest;
            while (p!=null){n = n+ ", " + String.valueOf(p.head);p = p.rest;}
        }
        return n;
    }

}
