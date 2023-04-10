import java.util.function.*;
import java.util.function.BiFunction;
public class MaxDemo {

    static<T> T maxValue(T[] items, BiFunction<T,T,Boolean> isLarger){
        T maxV;
        if(items.length==0){return null;}
        else {
            maxV = items[0];
            for (int i =1;i< items.length;i++){
                if(isLarger.apply(items[i],maxV)){maxV = items[i];}
            }
        }
        return maxV;
    }
    static <T extends HasIsLarger> T maxValue(T[] items){
        T maxV;
        if(items.length==0){return null;}
        else {
            maxV = items[0];
            for(int i = 1;i<items.length;i++){
                if(items[i].isLargerThan(maxV)){maxV = items[i];}
            }
        }
        return maxV;
    }

}

interface HasIsLarger<T> {boolean isLargerThan(T that);}


