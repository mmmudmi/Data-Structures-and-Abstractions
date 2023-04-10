import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Decor {
    static int len;
    public static BinaryTreeNode mkTree(List<Integer> postOrder, List<Integer> inOrder){
        if (postOrder.size()==0){return null;}
        int[] po = new int[postOrder.size()];
        int[] io = new int[inOrder.size()];
        for (int i = 0; i<po.length ; i++){
            po[i] = postOrder.get(i);
            io[i] = inOrder.get(i);
        }
        HashMap<Integer,Integer> indexIO = new HashMap<>();
        for (int i = 0; i < io.length; i++){indexIO.put(io[i],i);}
        len = io.length-1;
        return mkTreeHelper(po,0,io.length-1,indexIO );
    }

    private static BinaryTreeNode mkTreeHelper(int[] po, int start,int stop,HashMap<Integer,Integer> indexIO){
        if (start>stop){return null;} //The range
        else {
            BinaryTreeNode w = new BinaryTreeNode(po[len--]);
            if (start==stop){return w;} // {}  no range
            else {
                int index = indexIO.get(po[len+1]);
                //{start...index-1}{w.key}{index+1...stop}
                w.right = mkTreeHelper(po,index+1,stop,indexIO);
                w.left = mkTreeHelper(po,start,index-1,indexIO);
                return w;
            }
        }
    }
//     public static void preOrder(BinaryTreeNode n){
//         if (n!=null){
//             System.out.print(n.key + " ");
//             preOrder(n.left);
//             preOrder(n.right);
//         }
//     }
    public static void main(String[] args) {
//         List<Integer> po = new ArrayList<>();
//         po.add(8);
//         po.add(4);
//         po.add(5);
//         po.add(2);
//         po.add(6);
//         po.add(7);
//         po.add(3);
//         po.add(1);
//         List<Integer> io = new ArrayList<>();
//         io.add(4);
//         io.add(8);
//         io.add(2);
//         io.add(5);
//         io.add(1);
//         io.add(6);
//         io.add(3);
//         io.add(7);
//         preOrder(mkTree(po,io));
     }

}
