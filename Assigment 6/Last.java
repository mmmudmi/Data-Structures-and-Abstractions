public class Last {
    public static Integer binarySearchLast(int[] a, int k){
        if (a.length==0){return null;}
        return Helper(a,k,0,a.length-1);
    }
    public static Integer Helper(int[] a, int key, int start, int stop){
        if (start<stop){
            int mi = (start+stop)/2;
            if (a[mi]==key){
                if (a[mi+1]==key){return Helper(a,key,mi,stop);}
                else {return mi;}
            }
            if (a[mi] < key){return Helper(a,key,mi+1,stop);}
            else {return Helper(a,key,start,mi);}
        }
        if (start==stop && a[start]==key){return start;}
        return null;
    }

//    public static void main(String[] args) {
//        int[] a = {1,2,2,2,4,5};
//        System.out.println(binarySearchLast(a,1));
//    }
}

