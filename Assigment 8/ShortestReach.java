import java.util.*;


public class ShortestReach {
    interface UndirectedGraph<Integer>{
        int numEdges();
        int numVertices();
        int deg(Integer v);
        Iterable<Integer> adj(Integer v);
        boolean isEdge(Integer u, Integer v);
        void addVertex(Integer v);
        void addEdge(Integer u, Integer v);
        void removeEdge(Integer u, Integer v);
    }
    public static class  UndirectedAdjMap<Integer> implements UndirectedGraph<Integer>{
        private int numEdges;
        private int numVertices;
        private HashMap<Integer, List<Integer>> store;

        public UndirectedAdjMap(){
            numEdges=0;numVertices=0;
            store = new HashMap<Integer,List<Integer>>();
        }
        @Override
        public int numEdges() {
            return numEdges;
        }
        @Override
        public int numVertices() {
            return numVertices;
        }

        @Override
        public int deg(Integer v) {
            return store.get(v).size();
        }

        @Override
        public Iterable<Integer> adj(Integer v) {
            return store.get(v);
        }

        @Override
        public boolean isEdge(Integer u, Integer v) {
            return store.get(u).contains(v);
        }

        @Override
        public void addVertex(Integer v) {
            if (!store.containsKey(v)){
                List<Integer> a = new ArrayList<>();
                store.put(v,a);
                numVertices++;
            }
//            if (store.containsKey(v)){ store.remove(v);numVertices--;}
//            store.put(v,new ArrayList<>());
//            numVertices++;
        }

        @Override
        public void addEdge(Integer u, Integer v) {
            store.get(u).add(v);
            store.get(v).add(u);
            numEdges++;
        }
        @Override
        public void removeEdge(Integer u, Integer v) {
            store.get(u).remove(v);
            store.get(v).remove(u);
            numEdges--;
        }
    }


    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        UndirectedAdjMap<Integer> G = new UndirectedAdjMap<>();
        for (int i = 0 ; i<edges.size() ; i++){
            if (!G.store.containsKey(edges.get(i).get(0))){
                G.addVertex(edges.get(i).get(0));
            }
            if (!G.store.containsKey(edges.get(i).get(1))){
                G.addVertex(edges.get(i).get(1));
            }
            G.addEdge(edges.get(i).get(0),edges.get(i).get(1));
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        List<Integer> visited = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        List<Integer> c = allV(G,q,visited, count);
        for (int i = 0 ;i<n-m-1;i++){
            c.add(-1);
        }
        return c;
    }

    private static List<Integer> allV(UndirectedAdjMap<Integer> G, Queue<Integer> q, List<Integer> visited, List<Integer> count){
        int m = 1;
        int n = G.deg(q.peek());
        while (q.size()!=0){
            Integer v = q.poll();
            if (!visited.contains(v)){
                visited.add(v);
                for (Integer i: G.adj(v)){
                    if (!visited.contains(i)){q.add(i);count.add(m*6);n--;}
                }
            }
            if (n==0){m++; n=G.deg(v);}
        }
        return count;
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
