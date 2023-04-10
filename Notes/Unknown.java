import java.util.Arrays;
public class Unknown{
    public static int w;
    private static int x;
    private int y;
    public int[] z = new int[5];

    public Unknown() {w+=1; y=w;}
    public static void setX(int i) {x+=i;}
    public void setZ(int i) {z[y]=i; y+=1;}

    public int getW() {return w;}
    public int getX() {return x;}
    public int getY() {return y;}
    public int getZ(int i) {return z[i];}

    public static void main(String[] args) {
        Unknown u1 = new Unknown();
        u1.setZ(5);
        System.out.println(u1.getZ(2));
        Unknown u2 = new Unknown();
        u2.setZ(4);
        System.out.println(u2.getZ(2));
    }

}

