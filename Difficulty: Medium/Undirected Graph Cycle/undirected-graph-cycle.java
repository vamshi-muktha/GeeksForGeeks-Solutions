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
        for(int j = 0; j < V; j++){
            if(!vis[j]){
                Queue<Pair> q = new LinkedList<>();
                vis[j] = true;
                q.add(new Pair(j, -1));
                while(!q.isEmpty()){
                    Pair curr = q.remove();
                    
                    for(int i = 0; i < al.get(curr.f).size(); i++){
                        int x = al.get(curr.f).get(i);
                        
                        if(!vis[x]){
                            q.add(new Pair(x, curr.f));
                            vis[x] = true;
                        }
                        else if(x != curr.s && vis[x])return true;
                    }
                }
            }
        }
                
        return false;
    }
}