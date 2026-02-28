class Solution {
    public static ArrayList<Integer> findClosestPair(int arr1[], int arr2[], int x) {
        int n = arr1.length;
        int m = arr2.length;
        ArrayList<Integer> res = new ArrayList<>();
        int i = n-1;
        int j = 0;
        int min = Integer.MAX_VALUE;
        
        int a = -1;
        int b = -1;
        while(i >= 0 && j < m){
            int sum = arr1[i] + arr2[j];
            if(sum == x){
                res.add(arr1[i]);
                res.add(arr2[j]);
                return res;
            }
            if(Math.abs(sum - x) < min){
                a = i;
                b = j;
                min = Math.abs(sum - x);
            }
            
            if(sum < x){
                j++;
            }
            else{
                i--;
            }
        }
        
        res.add(arr1[a]);
        res.add(arr2[b]);
        return res;
        
    }
}