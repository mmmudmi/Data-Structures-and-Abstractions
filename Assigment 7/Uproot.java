import java.util.*;

public class Uproot {
    public static HashMap<Integer, Integer> treeToParentMap(BinaryTreeNode T){
        HashMap<Integer, Integer> ans = new HashMap<>();
        treeToParentMapHelper(T,ans);
        return ans;
    }
    private static void treeToParentMapHelper(BinaryTreeNode n, HashMap<Integer,Integer> m){
        if (n.left!=null){m.put(n.left.key,n.key); treeToParentMapHelper(n.left,m);}
        if (n.right!=null){m.put(n.right.key,n.key); treeToParentMapHelper(n.right,m);}
    }
    public static BinaryTreeNode parentMapToTree(Map<Integer, Integer> map){
        if (map.isEmpty()){return null;}
        int root = 0; //set anything
        for (Integer i: map.values()){
            if (!map.containsKey(i)){root = i;} //the real root
        }
        List<Integer> k = new ArrayList<>();
        for (Integer j: map.keySet().toArray(new Integer[0])){k.add(j);}

        return parentMapToTreeHelper(map,k,root);
    }
    private static BinaryTreeNode parentMapToTreeHelper(Map<Integer, Integer> map,List<Integer> keys,int root){
        BinaryTreeNode w = new BinaryTreeNode(root);
        if (map.isEmpty()){return w;}
        else {
            List<Integer> child = childOf(map,keys,root);
            if (child.size()==1){
                map.remove(child.get(0));
                keys.remove(child.get(0));
                w.left = parentMapToTreeHelper(map,keys,child.get(0));
                return w;
            }
            else if (child.size()==2){
                map.remove(child.get(0));
                map.remove(child.get(1));
                keys.remove(child.get(0));
                keys.remove(child.get(1));
                w.left = parentMapToTreeHelper(map,keys,child.get(0));
                w.right = parentMapToTreeHelper(map,keys,child.get(1));
                return w;
            }
            return w;
        }
    }
   public static List<Integer> childOf(Map<Integer,Integer> map, List<Integer> keys, int parent){
        List<Integer> a = new ArrayList<>();
        for (Integer i:keys){
            if (map.get(i)==parent){a.add(i);}
        }
        return a;
   }

//    public static void preOrder(BinaryTreeNode n){
//        if (n!=null){
//            System.out.print(n.key + " ");
//            preOrder(n.left);
//            preOrder(n.right);
//        }
//    }
//
//    public static void main(String[] args) {
//        int[]  a = {10,7,14,20,1,8};
//        BinaryTreeNode aa = MakeTree.buildBST(a);
//        preOrder(parentMapToTree(treeToParentMap(aa)));
//    }

}
