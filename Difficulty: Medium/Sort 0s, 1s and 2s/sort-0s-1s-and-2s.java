class Solution {
    public void sort012(int[] arr) {
        // code here
        int n = arr.length;
        int l = 0;
        int h = n-1;
        
        // for(int i = 0; i < n; i++){
        //     if(arr[i] == 0){
        //         swap(arr, i, l);
        //         l++;
        //     }
        //     else if(arr[i] == 2){
        //         swap(arr, i, h);
        //         h--;
        //     }
        // }
        
        int i = 0;
        while(i < n){
            if(arr[i] == 0){
                swap(arr, i, l);
                l++;
                i++;
            }
            else if(arr[i] == 2){
                if(i >= h)break;
                while(i < h && arr[i] == 2){
                    swap(arr, i, h);
                    h--;
                }
            }
            else{
                i++;
            }
        }
    }
    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}