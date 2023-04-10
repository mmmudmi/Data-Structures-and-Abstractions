import java.util.Iterator;
public class BoundedSkipper implements Iterable<Integer>{
    int[] result={1};
    public BoundedSkipper(int k, int n) {
        int count = 0;
        int[] r = new int[n];
        for (int i = 1;count<n;i++){
            if(i%k!=0&&!String.valueOf(i).contains(String.valueOf(k))){
                r[count] = i;
                count++;
            }
        }
        result = r;
    }
    private class BoundedSkipperIter implements Iterator<Integer>{
        private int itPos;
        public BoundedSkipperIter(){itPos=0;}
        public boolean hasNext(){return itPos< result.length;}
        public Integer next(){
            if(hasNext()) {
                Integer n = result[itPos];
                itPos++;
                return n;
            }
            else {
                throw new IndexOutOfBoundsException();
            }
        }
    }
    public Iterator<Integer> iterator(){return new BoundedSkipperIter();}

    public static void main(String[] args) {
        for (int i: new BoundedSkipper(3, 11)) {
            System.out.println(i); // prints out the above sequence on separate lines
        }
    }

}
