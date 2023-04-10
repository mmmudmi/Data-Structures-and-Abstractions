import java.util.*;

public class NearFib {
    public int numNearFib(long[] a, long t) {
        //use tree to check each element, if it fits the condition then add to the list
        if (a.length==1){
            return Math.abs(nearest(a[0])-a[0])<=t ? 1:0;
        }
        else {
            return numNearFib(Arrays.copyOfRange(a,0,a.length/2),t) +
                    numNearFib(Arrays.copyOfRange(a,a.length/2,a.length),t);
        }
    }
    private long nearest(long n){
        if (n==0){return 0;}
        long f = 0;
        long s = 1;
        //f1 = 0, f2 = 1 , f3 = f1+f2, f4 = f2+f3 ...
        long th = f+s;
        while (th<=n){
            f = s;
            s = th;
            th = f+s;
        }
        //check whether the current or prev Fib is closer
        if (Math.abs(th-n)<=Math.abs(s-n)){return th;}
        else {return s;}
    }

    public static void main(String[] args) {
        System.out.println(numNearFib);
    }
}
