//import java.util.Arrays;
public class Happy {
    public static void main(String[] args) {
    }

    public static long sumOfDigitsSquared(long n){
        String s = String.valueOf(n);
        long sum = 0;
        for (int i=0;i<s.length();i++){
            long num = Long.parseLong(s.substring(i,i+1));
            sum += num*num;
        }
        return sum;
    }
    public static boolean isHappy(long n){
        long a = n;
        for(int i=0;i>=0;i++){
            if (a == 1){
                return true;
            }
            else if (a == 4){
                return false;
            }
            else{
                a = sumOfDigitsSquared(a);
            }
        }
        return true;
    }
    public static long[] firstK(int k){
        long[] a = new long[k];
        int b = 0;
        for (long i=1;b<k;i++){
            if (isHappy(i)){
                a[b] = i;
                b++;
            }
        }
        return a;
    }
}
