// User function Template for Java

class Solution {
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        // your code here
        int n = arr.size();
        Collections.sort(arr);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n-m+1; i++){
            min = Math.min(arr.get(i+m-1) - arr.get(i), min);
        }
        return min;
    }
}