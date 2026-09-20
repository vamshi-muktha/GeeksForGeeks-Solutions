class Solution {
    public int largestSubsquare(char arr[][]) {
        // code here
        int n = arr.length;
        int[][] ro = new int[n][n];
        int[][] doo = new int[n][n];
        
        for(int i = 0; i < n; i++){
            int curr = n;
            for(int j = n-1; j >= 0; j--){
                if(arr[i][j] == 'O'){
                    curr = j;
                    ro[i][j] = j;
                }
                else
                ro[i][j] = curr;
            }
        }
        for(int i = 0; i < n; i++){
            int curr = n;
            for(int j = n-1; j >= 0; j--){
                if(arr[j][i] == 'O'){
                    curr = j;
                    doo[j][i] = j;
                }
                else
                doo[j][i] = curr;
            }
        }
        
        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 'X'){
                    int mino = Math.min(ro[i][j] - j, doo[i][j] - i);
                    for(int k = mino; k >= 1; k--){
                        if(ro[i+k-1][j] > j + k - 1 && doo[i][j+k-1] > i + k - 1){
                            if(max < k)max = k;
                            break;
                        }
                    }
                }    
            }
        }
        return max;
    }
};