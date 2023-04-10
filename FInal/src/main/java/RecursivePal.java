import java.util.*;

public class RecursivePal<T> {
    public boolean isRecursivePalindrome(T[] a) {
        if (a.length <= 3) { return isPalindrom(a);}
        //let's check the first half recursively
        return isRecursivePalindrome(Arrays.copyOfRange(a, 0, a.length / 2));
    }
    private boolean isPalindrom(T[] a){
        if(a.length<=1){return true;}
        if (a[0] == a[a.length-1]){
            return isPalindrom(Arrays.copyOfRange(a,1,a.length-1));
        }
        else {return false;}
    }

    public static void main(String[] args) {
        Integer[] a0 = {1, 1, 5, 1, 1};
        Integer[] a1 = {7, 8, 7, 7, 8, 7};
        Integer[] a2 = {2, 0, 4, 0, 2};
        Integer[] a3 = {7, 4, 5, 5, 4, 7, 9, 7, 4, 5, 5, 4, 7};

        System.out.println(new RecursivePal<>().isRecursivePalindrome(a0));
        System.out.println(new RecursivePal<>().isRecursivePalindrome(a1));
        System.out.println(new RecursivePal<>().isRecursivePalindrome(a2));
        System.out.println(new RecursivePal<>().isRecursivePalindrome(a3));
    }
}
