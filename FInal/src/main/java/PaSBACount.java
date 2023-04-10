import java.util.Arrays;

public class PaSBACount {
    public static long count(SortedBitArray[] packedArrays) {
        if (packedArrays.length==1){
            if (positionK(packedArrays[0],0,packedArrays[0].length())!=-1){
                return packedArrays[0].length()-positionK(packedArrays[0],0,packedArrays[0].length());
            }
        }
        int mi = packedArrays.length/2;
        SortedBitArray[] l = Arrays.copyOfRange(packedArrays,0,mi);
        SortedBitArray[] r = Arrays.copyOfRange(packedArrays,mi,packedArrays.length);
        return count(l) + count(r);
    }
//    private static int positionK(SortedBitArray a){
//        for (int i = 0 ; i< a.length() ; i++){
//            if (a.get(i)==1){return i;}
//        }
//        return -1;
//    }
    private static int positionK(SortedBitArray a, int start,int stop){
        if (start <= stop) {
            int mi = start + stop / 2;
            if (a.get(mi)==1) {
                return a.get(mi-1)==1 ? positionK(a, start, mi - 1) : mi;
            } else {
                return positionK(a,mi+1,stop);
            }
        } else {return -1;}
    }

    public static void main(String[] args) {
        SortedBitArray[] packedArrays = {
            new PackedSortedBitArray(5, 2),
            new PackedSortedBitArray(3, 1),
            new PackedSortedBitArray(4, 2),
            new PackedSortedBitArray(7, 3)
        };
        long expected = 11L;

        System.out.println("verdict: " + (expected==count(packedArrays)));
    }
}
