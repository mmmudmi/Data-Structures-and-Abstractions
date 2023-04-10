import java.util.Iterator;
public class BoundedSkipper implements Iterable<Integer>{
    int[] numb= {1};
    public BoundedSkipper(int k, int n) {
        int[] number = new int[n];
        int count = 0;
        for (int i = 1;count<n;i++){
            if(i%k!=0 && !String.valueOf(i).contains(String.valueOf(k))){
                number[count] = i;
                count++;
            }
        }
        numb = number;
    }
    private class BoundedSkipperIter implements Iterator<Integer>{
        private int itPos;
        public BoundedSkipperIter(){itPos = 0;}
        @Override
        public boolean hasNext() { return itPos < numb.length;}
        public Integer next(){
            if(hasNext()) {
                int toReturn = numb[itPos];
                itPos++;
                return toReturn;
            }
            else {
                throw new IndexOutOfBoundsException();
            }
        }
    }
    public Iterator<Integer> iterator(){return  new BoundedSkipper.BoundedSkipperIter();}

    public static void main(String[] args) {
        /*
        BoundedSkipper a = new BoundedSkipper(3, 11);
        for(int i: a){
            System.out.println(i);
        }
         */
    }
}


