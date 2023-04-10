import java.util.Arrays;
public class Subsel {
    public static void main(String[] args) {
    }
    public static int[] takeEvery(int[] a, int stride, int beginWith){
        int count = 0;
        for(int i =0;beginWith+(stride*i)<a.length && beginWith+(stride*i)>=0;i++){
            count ++;
        }
        int[] f = new int[count];
        for(int i =0;i<count;i++){
            f[i] = a[beginWith+(stride*i)];
        }
        return f;
    }
    public static int[] takeEvery(int[] a, int stride){
        return takeEvery(a,stride,0);
    }
}
