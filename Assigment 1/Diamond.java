public class Diamond {
    public static void main(String[] args) {

    }
    
    public static void printDiamond(int k){
        int countSq = k;
        int countSt = 0;
        for(int i=0;i<(2*k-1)-(k-1);i++){ //upper part
            for(int sq=countSq;sq>0;sq--){
                System.out.print('#');
            }
            for(int st=(countSt*2)+1;st>0;st--){
                System.out.print('*');
            }
            for(int sq=countSq;sq>0;sq--){
                System.out.print('#');
            }
            countSq--;
            countSt++;
            System.out.print("\r\n");
        }
        int countSq2 = 2;
        int countSt2 = k-1;
        for(int i=0;i<(2*k-1)-k;i++){ //half below
            for(int sq=countSq2;sq>0;sq--){
                System.out.print('#');
            }
            for(int st=(countSt2*2)-1;st>0;st--){
                System.out.print('*');
            }
            for(int sq=countSq2;sq>0;sq--){
                System.out.print('#');
            }
            countSq2++;
            countSt2--;
            System.out.print("\r\n");
        }
    }
}