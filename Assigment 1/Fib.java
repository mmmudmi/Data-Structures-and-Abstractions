public class Fib {
    public static void main(String[] args) {
    }
    public static int firstNDigit(int n){
        int count = 1;
        int f = 1;
        int s = 1;
        for(int i=3;count==1;i++){
            int cal = f+s;
            if (n==1){
                break;
            }
            else if (String.valueOf(cal).length()==n){
                count = i;
                break;
            }
            else{
                int oldF = f;
                f = s;
                s = oldF+s;
            }
        }
        return count;
    }
}
