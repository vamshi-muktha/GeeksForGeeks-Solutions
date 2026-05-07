class pair{
    int f;
    int s;
    int t;
    pair(int f, int s, int t){
        this.f = f;
        this.s = s;
        this.t = t;
    }
}

class Solution {
    public ArrayList<ArrayList<Integer>> nearest(int[][] arr) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int n = arr.length;
        int m = arr[0].length;
        for(int i = 0; i < n; i++){
            ArrayList<Integer> temp = new ArrayList<>();
            for(int j = 0; j < m; j++)temp.add(0);
            res.add(temp);
        }
        boolean[][] vis = new boolean[n][m];
        Queue<pair> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++)if(arr[i][j] == 1){
                q.add(new pair(i, j, 0));
                vis[i][j] = true;
            }
        }
        while(!q.isEmpty()){
            int x = q.size();
            for(int l = 0; l < x; l++){
                pair curr = q.remove();
                int i = curr.f;
                int j = curr.s;
                int k = curr.t;
                
                res.get(i).set(j, k);
                if(i - 1 >= 0 && !vis[i-1][j]){
                    q.add(new pair(i-1, j, k+1));
                    vis[i-1][j] = true;
                }
                if(i + 1 < n && !vis[i+1][j]){
                    q.add(new pair(i+1, j, k+1));
                    vis[i+1][j] = true;
                }
                if(j - 1 >= 0 && !vis[i][j-1]){
                    q.add(new pair(i, j-1, k+1));
                    vis[i][j-1] = true;
                }
                if(j + 1 < m && !vis[i][j+1]){
                    q.add(new pair(i, j+1, k+1));
                    vis[i][j+1] = true;
                }
            }
        }
        return res;
    }
}