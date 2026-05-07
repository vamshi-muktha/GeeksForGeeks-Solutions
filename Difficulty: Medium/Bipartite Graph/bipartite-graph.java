class pair{
    int f;
    int s;
    pair(int f, int s){
        this.f = f;
        this.s = s;
    }
}

class Solution {
    public boolean isBipartite(int V, int[][] arr) {
        // Code here
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for(int i = 0; i < V; i++){
            al.add(new ArrayList<>());
        }
        for(int i = 0; i < arr.length; i++){
            al.get(arr[i][0]).add(arr[i][1]);
            al.get(arr[i][0]).add(arr[i][1]);
        }
        int[] vis = new int[V];
        
        for(int i = 0; i < V; i++){
            if(vis[i] == 0)if(!helper(al, vis, i, 1))return false;
                
        }
        return true;
    }
    boolean helper(ArrayList<ArrayList<Integer>> al, int[] vis, int i, int c){
        if(vis[i] == -c)return false;
        if(vis[i] == c)return true;
        vis[i] = c;
        for(int x : al.get(i)){
            if(!helper(al, vis, x, -c))return false;
        }
        return true;
    }
}