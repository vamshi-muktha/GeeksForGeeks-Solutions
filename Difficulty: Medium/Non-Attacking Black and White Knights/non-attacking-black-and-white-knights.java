class Solution {
    public int numOfWays(int n, int m) {
        // code here
        int sum = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int tot = n * m - 1;
                if(j-2 >= 0 && i-1 >= 0){
                    tot--;
                }
                if(j-2 >= 0 && i+1 < n){
                    tot--;
                }
                if(i-2 >= 0 && j-1 >= 0){
                    tot--;
                }
                if(i-2 >= 0 && j+1 < m){
                    tot--;
                }
                if(j+2 < m && i-1 >= 0){
                    tot--;
                }
                if(j+2 < m && i+1 < n){
                    tot--;
                }
                if(i+2 < n && j-1 >= 0){
                    tot--;
                }
                if(i+2 < n && j+1 < m){
                    tot--;
                }
                sum += tot;
            }
        }
        return sum;
    }
}