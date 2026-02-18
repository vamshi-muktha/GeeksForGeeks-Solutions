class Solution {
    static int ans = 0;
    static int inversionCount(int arr[]) {
        // Code Here
        ans = 0;  
        mergeSort(arr, 0, arr.length-1);
        return ans;
    }
    static void mergeSort(int arr[], int l, int r) {
        // code here
        if(l >= r)return;
        int mid = (l + r)/2;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid+1, r);
        merge(arr, l, mid, r);
        
    }
    
    static void merge(int[] arr, int l, int mid, int h){
        int[] res = new int[h - l + 1];
        int i = l;
        int j = mid+1;
        int k = 0;
        
        while(i <= mid && j <= h){
            if(arr[i] <= arr[j]){
                res[k++] = arr[i++];
                
            }
            else{
                res[k++] = arr[j++];
                ans += (mid - i + 1);
            }
        }
        while(i <= mid){
            res[k++] = arr[i++];
        }
        while(j <= h){
            res[k++] = arr[j++];
        }
        
        for(int a = 0; a < res.length; a++){
            arr[l+a] = res[a];
        }
    }
}