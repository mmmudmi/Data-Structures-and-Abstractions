import java.util.*;

public class MultiwayMerge {
    public static LinkedList<Integer> mergeAll(LinkedList<Integer>[] lists){
        LinkedList<Integer> n = new LinkedList<>();
        PriorityQueue<Integer> a = Helper(lists);
        int s = a.size();
        for (int i = 0 ; i< s ; i++){
            n.add(a.poll());
        }
        return n;
    }
    private static PriorityQueue<Integer> Helper(LinkedList<Integer>[] lists){
        if (lists.length == 1){return new PriorityQueue<>(lists[0]);}
        else if (lists.length==2){ PriorityQueue<Integer> a = new PriorityQueue<>(lists[0]);
            a.addAll(lists[1]);
            return a;
        }
        else {
            int mi = lists.length/2 ;
            LinkedList<Integer>[] l = Arrays.copyOfRange(lists,0,mi);
            LinkedList<Integer>[] r = Arrays.copyOfRange(lists,mi,lists.length);
            PriorityQueue<Integer> a = new PriorityQueue<>(Helper(l));a.addAll(Helper(r));
            return a;
        }
    }

    public static void main(String[] args) {
//         LinkedList<Integer> a = new LinkedList<>();
//         a.add(1);
//         a.add(5);
//         a.add(6);
//         a.add(6);
//         LinkedList<Integer> b = new LinkedList<>();
//         b.add(3);
//         b.add(7);
//         LinkedList<Integer> c = new LinkedList<>();
//         c.add(1);
//         c.add(2);
//         c.add(4);
//         c.add(10);
//         LinkedList<Integer> d = new LinkedList<>();
//         d.add(8);
//         d.add(11);
//         LinkedList<Integer>[] n = new LinkedList[]{a, b,c,d};
//         LinkedList<Integer>[] e = new LinkedList[2];
//         e[0] = new LinkedList<>();
//         e[1] = new LinkedList<>();
//         System.out.println(mergeAll(e));
//         System.out.println(mergeAll(n));
    }
}