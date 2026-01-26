class Solution {
    public int getMinDiff(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int i = 0;
        int n = arr.length;
        int diff = arr[n-1] - arr[0];
        int min = arr[0] + k;
        int max = arr[n-1] - k;
        
        while(i < n-1){
            max = Math.max(arr[i] + k, arr[n-1] - k);
            min = Math.min(arr[i+1] - k, arr[0] + k);
            if(min > 0 && max > 0)
            diff = Math.min(diff, Math.abs(max - min));
            i++;
        }
        return diff;
    }
}
