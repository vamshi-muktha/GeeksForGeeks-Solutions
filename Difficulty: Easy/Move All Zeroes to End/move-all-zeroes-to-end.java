class Solution {
    void pushZerosToEnd(int[] arr) {
        // code here
        int n = arr.length;
        int j = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] != 0){
                swap(arr, i, j);
                j++;
            }
        }
        for(int i = j; i < n; i++)arr[i] = 0;
    }
    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}