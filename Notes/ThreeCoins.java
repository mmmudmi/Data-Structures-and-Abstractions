/*

 Thm: we can buy exact change with the price p>=20 by using infinitely 5cent, 11cent, 12cent.
 Predicate: P(i) = i baht can be perfectly paid by using only 5cent, 11cent, 12cent.
 Base Case:
            Let's manually assign a list of change from available cent stamps,
            where the total change is >=20 until 20+5.
            P(20): 5,5,5,5
            P(21): 11,5,5
            P(22): 12,5,5
            P(23): 11,12
            P(24): 12,12
            P(25): 5,5,5,5,5
 Indicate step: Assume that P(i+1) is also payable, where i+1 >= 26.
 Want to show: i+1 is payable
               i+1 = (i-4)+5
               where i-4 >= 22 <payable as shown in the base case> and 5 is payable(as in available the cents)

 THUS, any change P(i) that more than 25 will borrow P(i-5) change and +5.

 */
import java.util.ArrayList;
import java.util.List;
public class ThreeCoins {
    public static List<Integer> change(int n){
        if(n==20) return List.of(5,5,5,5);
        if(n==21) return List.of(11,5,5);
        if(n==22) return List.of(12,5,5);
        if(n==23) return List.of(11,12);
        if(n==24) return List.of(12,12);
        if(n==25) return List.of(5,5,5,5,5);
        List<Integer> nminus5 = new ArrayList<>(change(n-5));
        nminus5.add(5);
        return nminus5;
    }
    // For numWays(n) at least all the n will be able to use the method above, then way = 1;
    // after the process above if n is still be able to subtract by 11 or 12
    // I then add the number of ways up by one, until n is >=20
    public static int numWays(int n){
        int way = 1;
        int num = n;
        while(num>=31){
            if(num-11>=20){
                way++; num-=11;}
            if(num-12>=20){
                way++;num-=12;
            }
        }
        return way;
    }
    public static void main(String[] args) {
        //System.out.println(numWays(25+12+11));
    }
}
