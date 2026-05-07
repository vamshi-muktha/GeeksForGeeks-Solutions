class Solution {
    public boolean isCyclic(int V, int[][] arr) {
        // code here
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for(int i = 0; i < V; i++){
            al.add(new ArrayList<>());
        }
        for(int i = 0; i < arr.length; i++){
            al.get(arr[i][0]).add(arr[i][1]);
            al.get(arr[i][0]).add(arr[i][1]);
        }
        boolean vis[] = new boolean[V];
        boolean pv[] = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(!vis[i])if(helper(al, vis, pv, i))return true;
            
        }
        return false;
    }
    
    boolean helper(ArrayList<ArrayList<Integer>> al, boolean vis[], boolean pv[], int i){
        
        vis[i] = true;
        pv[i] = true;
        for(int x : al.get(i)){
            if(!vis[x] && helper(al, vis, pv, x))return true;
            if(vis[x] && pv[x])return true;
            
        }
        pv[i] = false;
        return false;
    }
}