class pair{
    int f;
    int s;
    pair(int f, int s){
        this.f = f;
        this.s = s;
    }
}

class Solution {
    int cntOnes(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        Queue<pair> q = new LinkedList<>();
        for(int i = 0; i < n; i++)if(arr[i][0] == 1)q.add(new pair(i, 0));
        for(int i = 0; i < m; i++)if(arr[0][i] == 1)q.add(new pair(0, i));
        for(int i = 0; i < n; i++)if(arr[i][m-1] == 1)q.add(new pair(i, m-1));
        for(int i = 0; i < m; i++)if(arr[n-1][i] == 1)q.add(new pair(n-1, i));
        
        while(!q.isEmpty()){
            pair curr = q.remove();
            int i = curr.f;
            int j = curr.s;
            arr[i][j] = 0;
            if(i+1 < n && arr[i+1][j] == 1)q.add(new pair(i+1, j));
            if(i-1 >= 0 && arr[i-1][j] == 1)q.add(new pair(i-1, j));
            if(j+1 < m && arr[i][j+1] == 1)q.add(new pair(i, j+1));
            if(j-1 >= 0 && arr[i][j-1] == 1)q.add(new pair(i, j-1));
        }
        
        int cnt = 0;
        for(int i = 0; i < n; i++)for(int j = 0; j < m; j++)if(arr[i][j] == 1)cnt++;
        return cnt;
    }
};