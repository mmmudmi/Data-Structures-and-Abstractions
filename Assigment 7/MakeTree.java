import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;




public class MakeTree {
    static void mergeSort(int[] array, Comparator<Integer> cc){  //mergeSort takes 2T(n/2)+O(n) = O(nlogn)
        int n = array.length; //O(1)
        if (n<=1) return; //O(1)
        int[] left= Arrays.copyOfRange(array,0,n/2); //O(n/2)
        int[] right= Arrays.copyOfRange(array,n/2,n); //O(n/2)
        mergeSort(left,cc); //T(n/2)
        mergeSort(right,cc); //T(n/2)
        mergeInto(left,right,array,cc); //O(n)
    }
    static void mergeInto(int[] x, int[] y, int[] out, Comparator<Integer> cc){ //mergeInto takes O(n)
        int i = 0, j = 0; //O(1)
        for (int k = 0; k<out.length ; k++){  //O(n)
            if (i>=x.length){
                out[k] = y[j++];
            }
            else if (j>=y.length){
                out[k] = x[i++];
            }
            else if(cc.compare(x[i],y[j])<0){
                out[k] = x[i++];
            }
            else {
                out[k] = y[j++];
            }
        }
    }

    public static BinaryTreeNode buildBSTHelper(int[] keys){ //buildBSTHelper takes 2T(n/2) + O(n) = O(nlogn)
        if (keys.length==1){return new BinaryTreeNode(keys[0]);} //O(1)
        else if (keys.length==2){
            return new BinaryTreeNode(buildBSTHelper(new int[]{keys[0]}), keys[1], null);} //O(1) it will run buildBST's first if above when keys.length is 1
        else {
            int mi = keys.length/2; // n/2
            int[] l = Arrays.copyOfRange(keys,0,mi);  //O(n/2)
            int m = keys[mi]; //O(1)
            int[] r = Arrays.copyOfRange(keys,mi+1,keys.length); //O(n/2)
            return new BinaryTreeNode(buildBSTHelper(l),m,buildBSTHelper(r)); //2T(n/2)
        }
    }
    public static BinaryTreeNode buildBST(int[] keys){
        mergeSort(keys, Integer::compareTo); // using mergeSort to sort the keys, which takes O(nlogn) times
        return buildBSTHelper(keys); //O(nlogn) times
    }

//---> The total time it takes is O(nlogn)+ O(nlogn) = + O(nlogn)


    public static void preOrder(BinaryTreeNode n){
        if (n!=null){
            System.out.print(n.key + " ");
            preOrder(n.left);
            preOrder(n.right);
        }
    }
    public static void main(String[] args) {
        // int[]  a = {1,2,3,4,5,6,7};
//         preOrder(buildBST(a));
    }

}

