import java.util.*;

public class PerfectHiding {
    public static int bestSpotDistance(List<WeightedEdge> passages) {
        List<Integer> visited = new ArrayList<>();
        //Map --> node: {prev,cost}
        HashMap<Integer,List<Integer>> m = new HashMap<>();
        Queue<Integer> q = new LinkedList<>();
        q.add(1);//always start at 1

        while (!q.isEmpty()){
            Integer v = q.poll();
            if(!visited.contains(v)){
                visited.add(v);
                if (v==1){
                    List<Integer> temp = new ArrayList<>();
                    //prev = null , cost = 0
                    temp.add(null);temp.add(0);
                    m.put(v,temp);
                }
                else {
                    //Map --> node: {prev,cost}
                    for (int i = 0 ; i<passages.size() ; i++){
                        if(v == passages.get(i).second){
                            //q.add(passages.get(i).second);
                            List<Integer> temp = new ArrayList<>();
                            temp.add(passages.get(i).first);
                            temp.add(passages.get(i).cost + m.get(passages.get(i).first).get(1));
                            m.put(v,temp);
                        }
                    }
                }
                for (int k = 0 ; k<passages.size() ; k++){
                    if(v == passages.get(k).first){
                        q.add(passages.get(k).second);
                    }
                }
            }
        }
        //{1=[null, 0], 2=[1, 1], 3=[2, 3], 4=[2, 6]}  6 is the longest path
        int largest = 0;
        for (Integer l: m.keySet()){
            if (m.get(l).get(1)>largest){largest=m.get(l).get(1);}
        }
        return largest;
    }
    public static void main(String[] args) {
        List<WeightedEdge> passages = new ArrayList<>(Arrays.asList(
                WeightedEdge.Edge(1, 2, 1),
                WeightedEdge.Edge(2, 3, 2),
                WeightedEdge.Edge(2, 4, 5)));
        int expcted = 6;
        boolean verdict = bestSpotDistance(passages)==expcted;
        System.out.println("verdict: "+verdict);
    }

}
