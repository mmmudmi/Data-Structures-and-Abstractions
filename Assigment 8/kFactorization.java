import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class kFactorization {
    private static void mergeSort(Integer[] array){
        int n = array.length;
        if (n<=1) return;
        Integer[] left= Arrays.copyOfRange(array,0,n/2);
        Integer[] right= Arrays.copyOfRange(array,n/2,n);
        mergeSort(left);
        mergeSort(right);
        mergeInto(left,right,array);
    }
    private static void mergeInto(Integer[] x, Integer[] y, Integer[] out){
        int i = 0, j = 0;
        for (int k = 0; k<out.length ; k++){
            if (i>=x.length){
                out[k] = y[j++];
            }
            else if (j>=y.length){
                out[k] = x[i++];
            }
            else if(x[i]<y[j]){
                out[k] = x[i++];
            }
            else {
                out[k] = y[j++];
            }
        }
    }
    public static List<Integer> kFactorization(int n, List<Integer> A) {
        Integer[] a = new Integer[A.size()];
        for (int i=0 ; i<A.size() ;i++){a[i] = A.get(i);}
        mergeSort(a);
        List<Integer> AA = new ArrayList<>();
        for (int j = 0 ; j<A.size() ; j++){
            AA.add(a[j]);
        }
        List<Integer> want = new ArrayList<>();
        List<Integer> r = new ArrayList<>();
        r.add(n);
        List<Integer> reverseWant = helper(AA.size(),n,AA,r);
        for (int i = reverseWant.size()-1 ;i>=0;i--){
            want.add(reverseWant.get(i));

        }
        if (want.size()==1){List<Integer> t = new ArrayList<>(); t.add(-1);return t; }
        return want;
    }

    private static List<Integer> helper(int c, int n, List<Integer> A, List<Integer> factors){
        if (c==0){//factors.add(1);
            return factors;}
        //if (A.size()==0){List<Integer> t = new ArrayList<>(); t.add(-1) ; return t;}
// do backward
        if (n % A.get(A.size()-1)==0){
            n = n/A.get(A.size()-1);
            factors.add(n);
        }
        A.remove(A.size()-1);
        return helper(c-1,n,A,factors);
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(2);
        a.add(4);
        a.add(6);
        a.add(9);
        a.add(3);
        a.add(7);
        a.add(16);
        a.add(10);
        a.add(5);
        System.out.println(kFactorization(72,a));
    }

}
