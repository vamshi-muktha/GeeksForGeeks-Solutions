class Solution {
    public boolean isCyclic(int V, int[][] arr) {
        // code here
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        for(int i = 0; i < V; i++){
            al.add(new ArrayList<>());
        }
        for(int i = 0; i < arr.length; i++){
            al.get(arr[i][0]).add(arr[i][1]);
        }
        boolean vis[] = new boolean[V];
        int[] in = new int[V];
        
        for(int i = 0; i < arr.length; i++){
            in[arr[i][1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(in[i] == 0)q.add(i);
        }
        int cnt = 0;
        while(!q.isEmpty()){
            int n = q.size();
            for(int i = 0; i < n; i++){
                int x = q.remove();
                vis[x] = true;
                cnt++;
                for(int k : al.get(x)){
                    if(!vis[k]){
                        in[k]--;
                        if(in[k] == 0)q.add(k);
                    }
                }
            }
        }
        return cnt != V;
    }
    
    
}