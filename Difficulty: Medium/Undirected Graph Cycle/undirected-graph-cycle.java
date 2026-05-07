class Pair{
    int f;
    int s;
    Pair(int f, int s){
        this.f = f;
        this.s = s;
    }
}

class Solution {
    public boolean isCycle(int V, int[][] arr) {
        // Code here
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for(int i = 0; i < V; i++){
            al.add(new ArrayList<>());
        }
        for(int i = 0; i < arr.length; i++){
            al.get(arr[i][0]).add(arr[i][1]);
            al.get(arr[i][1]).add(arr[i][0]);
        }
        boolean[] vis = new boolean[V];
        for(int i = 0; i < V; i++){
            if(!vis[i] && helper(al, vis, i, -1))return true;
        }
                
        return false;
    }
    
    boolean helper(ArrayList<ArrayList<Integer>> al, boolean[] vis, int i, int p){
        if(vis[i])return true;
        vis[i] = true;
        for(int x : al.get(i)){
            if(x != p && helper(al, vis, x, i))return true;
        }
        return false;
    }
}