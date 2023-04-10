import java.util.function.Predicate;

public class CountIf<T>{
    Predicate<T> pred;
    public CountIf(Predicate<T> pred){
        this.pred = pred;
    }
    public int count(T[] items){
        int count = 0;
        for(int i=0;i<items.length;i++){
            if(pred.test(items[i])){count++;}
        }
        return count;
    }
    /*
    private static class isEven implements Predicate<Integer> {
        @Override
        public boolean test(Integer x) {
            return x%2 == 0;
        }
    }

    public static void main(String[] args) {
        CountIf<Integer> countEven = new CountIf<>(new isEven());
        Integer[] numbers = new Integer[]{1,2,3,4,5};
        System.out.println(countEven.count(numbers));
    }

     */
}
