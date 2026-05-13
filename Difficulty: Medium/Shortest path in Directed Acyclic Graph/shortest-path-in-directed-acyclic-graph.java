// User function Template for Java
class Pair{
    int i;
    int j;
    Pair(int i, int j){
        this.i = i;
        this.j = j;
    }
}
class Solution {

    public int[] shortestPath(int V, int E, int[][] arr) {
        // Code here
        ArrayList<ArrayList<Pair>> al = new ArrayList<>();
        for(int i = 0; i < V; i++){
            al.add(new ArrayList<>());
        }
        for(int i = 0; i < arr.length; i++){
            al.get(arr[i][0]).add(new Pair(arr[i][1], arr[i][2]));
        }
        boolean vis[] = new boolean[V];
        ArrayList<Integer> topo = findTopo(al, vis, V);
        int[] dis = new int[V];
        for(int i = 1; i < V; i++)dis[i] = Integer.MAX_VALUE;
        for(int u : topo){
            for(Pair x : al.get(u)){
                int v = x.i;
                int wt = x.j;
            
                if(dis[u] != Integer.MAX_VALUE && dis[v] > dis[u] + wt){
                    dis[v] = dis[u] + wt;
                }
            }
        }
        
        for(int i = 0; i < V; i++)if(dis[i] == Integer.MAX_VALUE)dis[i] = -1;
        return dis;
    }
    ArrayList<Integer> findTopo(ArrayList<ArrayList<Pair>> al, boolean vis[], int n){
        int[] in = new int[n];
        for(int i = 0; i < n; i++){
            for(Pair p : al.get(i))in[p.i]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++)if(in[i] == 0)q.add(i);
        ArrayList<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int x = q.remove();
            res.add(x);
            for(Pair p : al.get(x)){
                
                in[p.i]--;
                if(in[p.i] == 0){
                    q.add(p.i);
                }
            }
                
        }
        return res;
    }
    
}