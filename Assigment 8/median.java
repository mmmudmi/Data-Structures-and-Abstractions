import java.util.Arrays;
import java.util.List;


//TODO: MERGE uses Integer

public class median {
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

    public static int findMedian(List<Integer> arr) {
        Integer[] a = arr.toArray(new Integer[0]);
        mergeSort(a);
        return a[a.length/2];
    }
}
