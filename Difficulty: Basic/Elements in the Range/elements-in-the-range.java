class Solution {
    public boolean checkElements(int start, int end, int[] arr) {
        // code here
        int n = arr.length, cnt = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] >= start && arr[i] <= end)cnt++;
        }
        return cnt == end - start + 1;
    }
}