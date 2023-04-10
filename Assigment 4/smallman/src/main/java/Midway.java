public class Midway {
    public static long stepsRemaining(int[] diskPos){
        long count = 0 ;
        if(diskPos.length==1){
            if (diskPos[0]!=1){count++;}
        }
        if (diskPos.length==3 && diskPos[1]!=diskPos[0] && diskPos[1]!=1){count-=1;}
        for (int i = 1; i< diskPos.length ;i++){
//---------------Special case where each Pec has 1 desk each-----------------
            if(diskPos.length==3 && diskPos[0]!=diskPos[1]&& diskPos[2]!=diskPos[1]){
                if (diskPos[2]==1) {count+=2;}
                else if (diskPos[2]==0) {count+=5;}
                else if (diskPos[2]==2) {count+=7;}
                break;
            }
//------for only i=1 cus we not yet have well stacked disks to use 2^n -1 moves-------
            else if(i==1 && diskPos[0]!=diskPos[1] && diskPos.length<3){count+=1;}
//---------------last disk-----------------------------
            else if(i==diskPos.length-1){
                if (diskPos[i]!=1){ //this!=1
                    if(diskPos[i-1]!=1){count+=2*pow(2,i)-2+1;}//prev != 1
                    else {count+=2*pow(2,i)-2+1;}//prev == 1
                } // do nothing when last disk = 1
                else if (diskPos[i]==1 && diskPos[i-1]!=1){count+=pow(2,i)-1;}
            }
//---------------if this != prev-------------------------
            else if (diskPos[i]!=diskPos[i-1]){count+=pow(2,i)-1;}
        }
        return count;
    }
    private static long pow(int b,int w){
        if(w==0)
            return 1;
        long t = pow(b,w/2);
        if(w%2==0)
            return t*t;
        else
            return b*t*t;
    }

}
