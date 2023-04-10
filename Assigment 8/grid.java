import java.util.ArrayList;
import java.util.List;

public class grid {
//    public static int connectedCell(List<List<Integer>> matrix) {
//        if (matrix.size()==0){return 0;}
//        int m = 0;
//        for(int i= 0 ; i< matrix.size() ; i++){
//            for (int j = 0 ; j<matrix.get(i).size(); j++){
//                if (matrix.get(i).get(j)==1){
//                    int r = helper(matrix,i,j);
//                    if (r>m){m=r;}
//                }
//            }
//        }
//        return m;
//    }
//    private static int helper(List<List<Integer>> matrix, int i , int j){
//         if (i<0 || j<0 || i>= matrix.size() || j>=matrix.get(0).size()){
//             return 0;
//         }
//         if (matrix.get(i).get(j)==0){return 0;}
//         else {
//             int count = 1;
//             matrix.get(i).remove(j);matrix.get(i).add(j,0);
//             for (int r = 0;r<3 ;r++){
//                 for (int c = 0; c<3 ; c++){
//                     if (r!=i || c!= j){count += helper(matrix,r,c);}
//                 }
//             }
//             return count;
//         }
//    }
    public static int connectedCell(List<List<Integer>> matrix){
        if (matrix.size()==0){return 0;}
        int m = 0;
        List<Integer> xi = new ArrayList<>();
        xi.add(-1);xi.add(-1);xi.add(-1);xi.add(0);xi.add(0);xi.add(0);xi.add(1);xi.add(1);xi.add(1);
        List<Integer> yi = new ArrayList<>();
        yi.add(-1);yi.add(0);yi.add(1);yi.add(-1);yi.add(0);yi.add(1);yi.add(-1);yi.add(0);yi.add(1);
        for(int i= 0 ; i< matrix.size() ; i++){
            for (int j = 0 ; j<matrix.get(i).size(); j++){
                int r = helper(matrix,i,j,0,xi,yi);
                if (r>m){m=r;}
            }
        }
        return m;
    }
    private static int helper(List<List<Integer>> matrix, int i , int j, int c, List<Integer> xi, List<Integer> yi){
        if (matrix.get(i).get(j)!=1){return c;}
        else {
            c++;
            matrix.get(i).remove(j);matrix.get(i).add(j,0);
            for (int k = 0; k < xi.size() ; k++){
                if (0<= i+xi.get(k)&&i+xi.get(k)<matrix.size() && 0<=j+yi.get(k) && j+yi.get(k) <matrix.get(0).size()){
                    int temp = helper(matrix,i+xi.get(k),j+yi.get(k),c,xi,yi);
                    if (temp>c){c=temp;}
                }
            }
            return c;
        }
    }


public static void main(String[] args) {
    List<Integer> n1 = new ArrayList<>();
    n1.add(1);n1.add(1);n1.add(0);n1.add(0);n1.add(0);
    List<Integer> n2 = new ArrayList<>();
    n2.add(0);n2.add(1);n2.add(1);n2.add(0);n2.add(0);
    List<Integer> n3 = new ArrayList<>();
    n3.add(0);n3.add(0);n3.add(1);n3.add(0);n3.add(1);
    List<Integer> n4 = new ArrayList<>();
    n4.add(1);n4.add(0);n4.add(0);n4.add(0);n4.add(1);
    List<Integer> n5 = new ArrayList<>();
    n5.add(0);n5.add(1);n5.add(0);n5.add(1);n5.add(1);
    List<List<Integer>> n = new ArrayList<>();
    n.add(n1);n.add(n2);n.add(n3);n.add(n4);n.add(n5);
    System.out.println(connectedCell(n));
}
}
