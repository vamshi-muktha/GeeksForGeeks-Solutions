class Solution {
    public int findKRotation(int arr[]) {
        // Code here
        int n = arr.length;
        if(arr[0] < arr[n-1] || n <= 1)return 0;
        
        int l = 0;
        int h = n-1;
        while(l <= h){
            int mid = (l+h)/2;
            if(arr[mid] > arr[mid+1])return mid+1;
            if(arr[mid] < arr[h]){
                h = mid;
            }
            else{
                l = mid + 1;
            }
        }
        return 0;
    }
}