import java.util.*;

public class shortest2 {
    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        List<List<Integer>> graph = new ArrayList<>(), distances = new ArrayList<>();
        List<List<Boolean>> visited = new ArrayList<>();
        List<Integer> start = new ArrayList<>();
        for (int i = 0 ; i < n+1 ;i++){
            List<Integer> a = new ArrayList<>();
            graph.add(a);
            List<Boolean> b = new ArrayList<>();
            b.add(false);
            visited.add(b);
            a.add(-1);
            distances.add(a);
        }
        for (int j = 0;j<edges.size();j++){
            graph.get(edges.get(j).get(0)).add(edges.get(j).get(1));
            graph.get(edges.get(j).get(1)).add(edges.get(j).get(0));
        }
        Queue<List<Integer>> q = new LinkedList<>();
        start.add(s);start.add(0);
        q.add(start);
        distances.get(s).remove(0); distances.get(s).add(0);
        visited.get(s).remove(0);visited.get(s).add(true);
        while (!q.isEmpty()){
            Integer u = q.peek().get(0);
            //System.out.println(q.peek());
            Integer w = q.peek().get(1);
            q.poll();
            for (Integer v : graph.get(u)){

                if (!visited.get(v).get(0)){
                    distances.get(v).remove(0);
                    distances.get(v).add(w+6);
                    visited.get(v).remove(0);
                    visited.get(v).add(true);
                    List<Integer> qq = new ArrayList<>();
                    qq.add(v);qq.add(w+6);
                    q.add(qq);
                }
            }
        }
        System.out.println(distances);
        distances.remove(0);
        List<Integer> a = new ArrayList<>();
        for (int k = 1;k<distances.size();k++){
            a.add(distances.get(k).get(0));
        }
        return a;
    }



    public static void main(String[] args) {
        List<List<Integer>> e = new ArrayList<>();
        List<Integer> e1 = new ArrayList<>();
        e1.add(1);
        e1.add(2);
        List<Integer> e2 = new ArrayList<>();
        e2.add(1);
        e2.add(3);
        List<Integer> e3 = new ArrayList<>();
        e3.add(3);
        e3.add(4);
//        List<Integer> e4 = new ArrayList<>();
//        e4.add(1);
//        List<Integer> e5 = new ArrayList<>();
//        e5.add(3);
//        e5.add(1);
//        List<Integer> e6 = new ArrayList<>();
//        e6.add(2);
//        e6.add(3);
//        List<Integer> e7 = new ArrayList<>();
//        e7.add(2);
        e.add(e1);
        e.add(e2);
        e.add(e3);
//        e.add(e4);
//        e.add(e5);
//        e.add(e6);
//        e.add(e7);
        System.out.println(bfs(5,3,e,1));
    }
}

