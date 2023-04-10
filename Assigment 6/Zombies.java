import java.util.Arrays;

public class Zombies {
    //human: tall->short
    public static int countBad(int[] hs){
        if (isTallToShort(hs)){return 0;}
        int countBad = 0;
        for (int i=0 ;i<hs.length; i++){
            countBad += countBadHelper(Arrays.copyOfRange(hs,i,hs.length+1),hs[i],0);
        }
        return countBad;
    }
    private static int countBadHelper(int[] hs, int k, int count){
        if (hs.length==1){
            if (hs[0] > k){return 1;}
            else {return 0;}
        }
        else {
            int n = hs.length;
            int[] left = Arrays.copyOfRange(hs,0,n/2);
            int[] right = Arrays.copyOfRange(hs,n/2,n);
            return countBadHelper(left,k,count)+countBadHelper(right,k,count);
        }
    }
        private static boolean isTallToShort(int[] items){
        for (int i = 0; i<items.length-1;i++){
            if (items[i]<items[i+1]){return false;}
        }
        return true;
    }
    // public static void main(String[] args) {
//         int[] aa = {35, 22, 10};
//         System.out.println(countBad(aa));
//         int[] a = {3,1,4,2};
//         System.out.println(countBad(a));
//         int[] b = {5,4,11,7};
//         System.out.println(countBad(b));
//         int[] c = {1, 7, 22, 13, 25, 4, 10, 34, 16, 28, 19, 31};
//         System.out.println(countBad(c));
//     }
}
