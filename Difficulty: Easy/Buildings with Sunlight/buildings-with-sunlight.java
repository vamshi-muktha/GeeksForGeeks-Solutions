class Solution {
    public int visibleBuildings(int arr[]) {
        // code here
        int n = arr.length;
        int res = 0;
        int cm = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] >= cm)res ++;
            cm = Math.max(cm, arr[i]);
        }
        return res;
    }
}