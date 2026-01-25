class Solution {
    public int minMen(int arr[]) {
        int n = arr.length;
        ArrayList<int[]> al = new ArrayList<>();
        
        for(int i = 0; i < n; i++){
            if(arr[i] == -1){
                continue;
            }
            int[] temp = new int[2];
            temp[0] = i - arr[i] < 0 ? 0 : i - arr[i];
            temp[1] = i + arr[i] >= n ? n : arr[i] + i+1;
            al.add(temp);
        }
        Collections.sort(al, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        if(al.size() == 0 || al.get(0)[0] != 0)return -1;
        int res = 0;
        int i = 0;
        int ce = 0;
        while(ce < n){
            int far = ce;
            while(i < al.size() && ce >= al.get(i)[0]){
                far = Math.max(far, al.get(i)[1]);
                i++;
            }
            if(far == ce)return -1;
            res ++;
            ce = far;
        }
        return res;
    }
}