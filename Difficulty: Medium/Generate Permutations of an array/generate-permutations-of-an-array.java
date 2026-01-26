class Solution {
    public static ArrayList<ArrayList<Integer>> permuteDist(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        boolean vis[] = new boolean[n];
        
        helper(arr, n, 0, new ArrayList<>(), res, vis);
        return res;
    }
    
    
    static void helper(int[] arr, int n, int i, ArrayList<Integer> al, ArrayList<ArrayList<Integer>> res, boolean vis[]){
        if(i == n){
            res.add(new ArrayList<>(al));
            return;
        }
        for(int j = 0; j < n; j++){
            if(!vis[j]){
                vis[j] = true;
                al.add(arr[j]);
                helper(arr, n, i+1, al, res, vis);
                al.remove(al.size() - 1);
                vis[j] = false;
            }
        }
    }
};