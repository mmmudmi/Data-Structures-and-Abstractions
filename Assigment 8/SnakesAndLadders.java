import java.util.*;

public class SnakesAndLadders {
    public static int quickestWayUp(List<List<Integer>> ladders, List<List<Integer>> snakes) {
        HashSet<Integer> s = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer,Integer> path = new HashMap<Integer, Integer>();
        loadPaths(ladders,snakes,path);
        return helper(q,path,s);
    }
    private static int helper(Queue<Integer> q,  HashMap<Integer,Integer> path, Set<Integer> taken){
        int min = 0;
        q.add(1);
        while (!q.isEmpty()){
            min++;
            int numPoss = q.size();
            for (int i = 0 ; i<numPoss ;i++){
                Integer c = q.poll();
                for (int pos = 6; pos>0; pos--){
                    int newPos = c+pos;
                    if (path.containsKey(newPos)){
                        taken.add(newPos);
                        newPos = path.get(newPos);
                    }
                    if (newPos == 100){return min;}
                    if (!taken.contains(newPos) && newPos<100){
                        taken.add(newPos);
                        q.add(newPos);
                    }

                }
            }
        }
        return -1;
    }
    private static void loadPaths(List<List<Integer>> ladders, List<List<Integer>> snakes, HashMap<Integer,Integer> path){
        for (List<Integer> i : ladders){
            path.put(i.get(0),i.get(1));
        }
        for (List<Integer> j : snakes){
            path.put(j.get(0),j.get(1));
        }
    }
}
