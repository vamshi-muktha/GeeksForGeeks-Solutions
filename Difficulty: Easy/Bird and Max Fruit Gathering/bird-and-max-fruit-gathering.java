class Solution {
    public int maxFruits(ArrayList<Integer> arr, int m) {
        // code here
        int max = 0;
        int n = arr.size();
        int[] cs = new int[n];
        cs[0] = arr.get(0);
        for(int i = 1; i < n; i++)cs[i] = cs[i-1] + arr.get(i);
        for(int i = 0; i < n-(m-1); i++){
            max = Math.max(max, cs[i+m-1] - (i == 0 ? 0 : cs[i-1]));
        }
        for(int i = n-(m-1); i < n; i++){
            max = Math.max(max, cs[n-1] - cs[i-1] + cs[m-(n-i+1)]);
        }
        return max;
        
        
    }
}