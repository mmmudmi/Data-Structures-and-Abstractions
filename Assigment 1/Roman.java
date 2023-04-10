public class Roman {
    public static void main(String[] args) {
    }
    public static int[] newA(String romanNum){
        //convert str into int[] array and change to num
        int[] a = new int[romanNum.length()];
        for(int j=0;j<a.length;j++){
            switch(romanNum.charAt(j)){
                case 'I': a[j] = 1;
                    break;
                case 'V': a[j] = 5;
                    break;
                case 'X': a[j] = 10;
                    break;
                case 'L': a[j] = 50;
                    break;
                case 'C': a[j] = 100;
                    break;
                case 'D': a[j] = 500;
                    break;
                case 'M': a[j] = 1000;
                    break;
            }
        }
        int countN = a.length;
        for(int i=0;i<a.length-1;i++){
            for(int ii=i+1;ii<i+2;ii++){
                if(a[i]==a[ii]){
                    countN--;
                }
            }
        }
        int[] n = new int[countN];
        int countH = 0;
        int current = 0;
        int index = 0;

        for(int h=0;h<a.length-1;h++){
            current = a[h];
            int nowH =h+1;

            for(int hh=nowH;hh==nowH;hh++){
                if (a[h]==a[hh]){
                    current+=a[hh];
                    for(int hhh=hh;hhh==hh;hhh++){
                        if (a[hh]==a[hhh]){
                            current+=a[hhh];
                            n[index]=current;
                            index ++;
                            h+=2;
                            break;
                        }
                        else{
                            n[index]=current;
                            index ++;
                            h+=1;
                        }
                    }
                }
                else{
                    n[index]=current;
                    index++;
                }

            }
        }
        int countLeft = 0;
        for(int k =a.length-1;k>=0;k--){
            if (a[k]==a[a.length-1]){
                countLeft++;
            }
            else{
                break;
            }
        }
        int left = a[a.length-1]*countLeft;
        n[n.length-1]= left;
        return n;
    }
    public static int romanToInt(String romanNum){
        int count = 0;
        int[] a = newA(romanNum);
        for(int i=0;i<a.length;i++){
            if(i+1<a.length){
                if(a[i+1]<=a[i]){
                    count += a[i];
                }
                else{
                    count = a[i+1]-a[i]+count;
                    i++;
                }
            }
            else{
                count += a[i];
            }
        }
        return count;
    }

}
