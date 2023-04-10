import java.math.BigInteger;
public class Exercise2 {
    public static void main(String[] args) {

    }

    //1st question
    public static int numTrailingZeros(int n) {
        BigInteger nFac = BigInteger.valueOf(1);
        for (int k = 2; k <= n; k++) {
            nFac = nFac.multiply(BigInteger.valueOf(k));
        }
        String a = nFac.toString();
        int count = 0;
        for (int i = a.length() - 1; i >= 0; i--) {
            if (a.charAt(i) == '0') {
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    //2nd question
    public static void windowPosSum(int[] a, int n) {
        int[] f = new int[a.length];
        for (int i = 0; i < f.length; i++) {
            if (i == f.length - 1 || a[i] < 0) {
                f[i] = a[i];
            } else if (f.length - i > n) {
                int count = 0;
                int round = 0;
                for (int j = i; round <= n; j++) {
                    count += a[j];
                    round++;
                }
                f[i] = count;
            } else {
                int countt = 0;
                for (int h = i; f.length - h >= 1; h++) {
                    countt += a[h];
                }
                f[i] = countt;
            }
        }
        a = f;

    }
}



