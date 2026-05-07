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
            if(vis[i] == 0){
                Queue<pair> q = new LinkedList<>();
                q.add(new pair(i, 1));
                vis[i] = 1;
                while(!q.isEmpty()){
                    pair curr = q.remove();
                    for(int x : al.get(curr.f)){
                        if(vis[x] == 0){
                            q.add(new pair(x, -curr.s));
                            vis[x] = -curr.s;
                        }
                        else if(vis[x] == curr.s)return false;
                    }
                }
            }
        }
        return true;
    }
}