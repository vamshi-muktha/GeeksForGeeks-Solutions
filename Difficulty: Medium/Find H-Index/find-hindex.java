class Solution {
    public int hIndex(int[] arr) {
        // code here
        int n = arr.length;
        int[] cnt = new int[n+1];
        
        for(int i = 0; i < n; i++){
            if(arr[i] > n)cnt[n]++;
            else cnt[arr[i]]++;
        }
        
        for(int i = n-1; i >= 0; i--)cnt[i] = cnt[i] + cnt[i+1];
        for(int i = n; i >= 0; i--)if(cnt[i] >= i)return i;
        return 0;
        
    }
}