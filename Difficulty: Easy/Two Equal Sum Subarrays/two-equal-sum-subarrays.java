class Solution {
    public boolean canSplit(int arr[]) {
        // code here
        int n = arr.length;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
        }
        if(sum % 2 == 1)return false;
        sum/=2;
        for(int i = 0; i < n; i++){
            sum -= arr[i];
            if(sum == 0)return true;
            if(sum < 0)return false;
        }
        return false;
    }
}