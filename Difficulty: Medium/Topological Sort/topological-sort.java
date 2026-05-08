class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] arr) {
        // code here
        int n = V;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < arr.length; i++){
            adj.get(arr[i][0]).add(arr[i][1]);
            adj.get(arr[i][1]).add(arr[i][0]);
        }
        int[] in = new int[n];
        for(int i = 0; i < arr.length; i++){
            in[arr[i][1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < n; i++){
            if(in[i] == 0){
                q.add(i);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            int x = q.remove();
            res.add(x);
            for(int i : adj.get(x)){
                
                in[i]--;
                if(in[i] == 0){
                    q.add(i);
                }
            }
                
        }
        return res;
    }
    
}