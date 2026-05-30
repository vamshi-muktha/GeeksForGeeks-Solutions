class Solution {
    public void replaceElements(int[] arr) {
        // code here
        int n = arr.length;
        int prev = arr[0];
        int next = arr[1];
        int i = 0;
        while(i < n){
            int np = arr[i];
            arr[i] = prev ^ next;
            prev = np;
            next = i < n-2 ? arr[i + 2] : arr[n-1];
            i++;
        }
    }
}