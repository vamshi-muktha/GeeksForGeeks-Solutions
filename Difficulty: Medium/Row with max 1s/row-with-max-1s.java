// User function Template for Java

class Solution {
    public int rowWithMax1s(int arr[][]) {
        // code here
        int n = arr.length;
        int m = arr[0].length;
        int i = 0;
        int j = m - 1;
        int max = m;
        int maxi = -1;
        while(i < n && j >= 0){
            if(arr[i][j] == 0){
                i++;
            }
            else{
                j--;
                if(j < max){
                    max = j;
                    maxi = i;
                }
            }
        }
        return maxi;
    }
}