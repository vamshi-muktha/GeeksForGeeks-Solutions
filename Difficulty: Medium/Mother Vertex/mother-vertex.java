class Solution {
    public int findMotherVertex(int V, int[][] arr) {
        // code here
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for(int i = 0; i < V; i++){
            al.add(new ArrayList<>());
        }
        for(int i = 0; i < arr.length; i++){
            al.get(arr[i][0]).add(arr[i][1]);
        }
        boolean vis[] = new boolean[V];
        int curr = -1;
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                dfs(al, vis, i);
                curr = i;
            }
        }
        for(int i = 0; i < V; i++)vis[i] = false;
        dfs(al, vis, curr);
        for(int i = 0; i < V; i++){
            if(!vis[i])return -1;
        }
        return curr;
    }
    void dfs(ArrayList<ArrayList<Integer>> al, boolean vis[], int i){
        if(vis[i])return;
        vis[i] = true;
        for(int x : al.get(i)){
            if(!vis[x])dfs(al, vis, x);
        }
    }
}