import java.math.BigInteger;

public class SuperPower {
    public static int numSPUpTo(int n) {
        int count =0;
        for(long i=50;i<=n;i++) {
            BigInteger s = BigInteger.valueOf(i).multiply(BigInteger.valueOf(i)).multiply(BigInteger.valueOf(i)).multiply(BigInteger.valueOf(i))
                            .multiply(BigInteger.valueOf(i)).multiply(BigInteger.valueOf(i)).multiply(BigInteger.valueOf(i));
            String sp = String.valueOf(s);
            if (sp.contains("0") && sp.contains("1") && sp.contains("2") && sp.contains("3")
                    && sp.contains("4") && sp.contains("5") && sp.contains("6") && sp.contains("7")
                    && sp.contains("8") && sp.contains("9")) {
                count++;
            }
        }
	return count;
    }
    public static int kthSP(int k) {
        int count =0;
        int r=0;
        for (int i =0;count<=k;i++){
            if(count==k){r = i^7;}
            if((i^7)==numSPUpTo(i^7)){count++;}
        }
        return r;
    }
}
