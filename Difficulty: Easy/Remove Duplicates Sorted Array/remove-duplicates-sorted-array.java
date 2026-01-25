class Solution {
    ArrayList<Integer> removeDuplicates(int[] arr) {
        // code here
        int n = arr.length;
        ArrayList<Integer> al = new ArrayList<>();
        for(int i = 0; i < n-1; i++){
            if(arr[i] == arr[i+1]){
                continue;
            }
            al.add(arr[i]);
        }
        al.add(arr[n-1]);
        return al;
    }
}
