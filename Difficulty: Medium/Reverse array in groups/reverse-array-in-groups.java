class Solution {
    public void reverseInGroups(int[] arr, int k) {
        // code here
        int n = arr.length;
        int i = 0;
        for(i = 0; i < n; i += k){
            int r = i + k - 1;
            if(r < n)reverse(arr, i , r);
            else reverse(arr, i, n-1);
        }
       
    }
    void reverse(int[] arr, int i, int j){
        for(int k = i; k <= (i + j)/2; k++){
            swap(arr, k, j - (k - i));
        }
    }
    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}