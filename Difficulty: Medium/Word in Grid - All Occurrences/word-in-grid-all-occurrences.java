class Solution {
    public ArrayList<ArrayList<Integer>> searchWord(char[][] arr, String w) {
        // code here
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        int n = arr.length;
        int m = arr[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] == w.charAt(0))if(dfs(i, j, arr, w, n, m)){
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    al.add(temp);
                }
            }
        }
        return al;
    }
    
    boolean dfs(int i, int j, char[][] arr, String w, int n, int m){
        int len = w.length();
        if(j + len - 1 < m ){
            for(int k = 0; k < len; k++){
                if(arr[i][j+k] != w.charAt(k))break;
                if(k == len - 1)return true;
            }
        }
        if(j - len + 1 >= 0 ){
            for(int k = 0; k < len; k++){
                if(arr[i][j-k] != w.charAt(k))break;
                if(k == len - 1)return true;
            }
        }if(i + len - 1 < n ){
            for(int k = 0; k < len; k++){
                if(arr[i+k][j] != w.charAt(k))break;
                if(k == len - 1)return true;
            }
        }if(i - len + 1 >= 0 ){
            for(int k = 0; k < len; k++){
                if(arr[i-k][j] != w.charAt(k))break;
                if(k == len - 1)return true;
            }
        }
        if(j + len - 1 < m && i + len - 1 < n){
            for(int k = 0; k < len; k++){
                if(arr[i+k][j+k] != w.charAt(k))break;
                if(k == len - 1)return true;
            }
        }
        if(j - len + 1 >= 0 && i - len + 1 >= 0 ){
            for(int k = 0; k < len; k++){
                if(arr[i-k][j-k] != w.charAt(k))break;
                if(k == len - 1)return true;
            }
        }
        if(j + len - 1 < m && i - len + 1 >= 0){
            for(int k = 0; k < len; k++){
                if(arr[i-k][j+k] != w.charAt(k))break;
                if(k == len - 1)return true;
            }
        }
        if(j - len + 1 >= 0 && i + len - 1 < n){
            for(int k = 0; k < len; k++){
                if(arr[i+k][j-k] != w.charAt(k))break;
                if(k == len - 1)return true;
            }
        }
        return false;
    }
};