public class Hidden {
    public static void main(String[] args) {
    }
    public static boolean isHidden(String s, String t){
        String left = s;
        int count=0;
        for (int i=0;i<t.length();i++){
            for(int j=0;j<left.length();j++){
                if (t.charAt(i)==left.charAt(j)){
                    count++;
                    left = left.substring(j+1);
                    break;
                }
            }
        }
        return t.length()==count;
    }
}
