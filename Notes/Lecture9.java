import java.util.ArrayList;
import java.util.List;
public class Lecture9 {
    public static void main(String[] args) {
        System.out.println();
    }
    List<Integer> change(int n){
        // key in the ans from 24-28
        if(n==24) return List.of(5,5,7,7);
        if(n==25) return List.of(5,5,5,5,5);
        if(n==26) return List.of(7,7,7,5);
        if(n==27) return List.of(5,5,5,5,7);
        if(n==28) return List.of(7,7,7,7);

        // a list of making n=5
        List<Integer> nminus5 = new ArrayList<>(change(n-5));
        nminus5.add(5);
        return nminus5;
    }
    public int pow(int b,int w){
        if (w==0) return 1;
        int t = pow(b,w/2);
        if(w%2==0) return t*t;
        else return t*t*b;
    }
    int factHelper(int n, int a){
        if (n==0) return a;
        return factHelper(n-1,a*n);
    }
    // CLAIM: fact(n) ==> n!
    int fact(int n){return factHelper(n,1);}

}
