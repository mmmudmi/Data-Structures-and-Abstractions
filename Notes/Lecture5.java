class IntArrayList{
    private int[] items;  //<- null
    private int size; //to count how many real elements we've got(different from .length)//like a virtual fench if anything over= garbage
    //.length counts everything {1,2,3,0,0,0,0,0}
    //size considers only real data {1,2,3}
    public IntArrayList(){
        items = new int[1]; // as soon as this thing is full there will be one more
        size = 0;
    }
    public void grow(int newCap){
        //Allocate a new array
        int[] expandedItems = new int[newCap];
        //copy the items from the old array into this new one
        System.arraycopy(items,0,expandedItems,0,size);
        //replace items with this new array
        items = expandedItems;
    }
    public void addLast(int x){
        //if full
        if(size == items.length){
            //grow this items array
            grow(size+20); //if +1 by 1 will get longer to run cus it keeps copy often //let's do 2*size
        }
        items[size] = x;
        size++;
    }
    public int size() {return size;}
    public int getFirst() {return items[0];}
    public int getLast() {return items[size-1];}
    public int get(int k) {return items[k];}
    public void removeLast() {
        items[size-1] = 0;
        size--;
    }

}
public class Lecture5 {
    public static void main(String[] args) {
        IntArrayList al = new IntArrayList();
        long start = System.currentTimeMillis();
        for (int i =0 ;i<=10000;i++){ al.addLast(i);}
        long stop = System.currentTimeMillis();
        System.out.println(al.getLast());
        System.out.println("Time taken: " + (stop-start) + "ms");
    }


}
