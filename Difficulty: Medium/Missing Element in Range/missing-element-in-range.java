class Solution {
    public ArrayList<Integer> missingRange(int[] arr, int low, int high) {
        // code here
        Arrays.sort(arr);
        ArrayList<Integer> res = new ArrayList<>();
        int n = arr.length;
        if(low < arr[0])for(int i = low; i < arr[0]; i++)if(i <= high)res.add(i);
        for(int i = 1; i < n; i++){
            if(arr[i] > high && arr[i-1] > high)break;
            if(arr[i] < low)continue;
            for(int j = arr[i-1]+1; j < arr[i]; j++)if(j >= low && j <= high)res.add(j);
        }
        if(high > arr[n-1])for(int i = arr[n-1] + 1; i <= high; i++)if(i >= low)res.add(i);
        return res;
    }
}