class Solution {
    public ArrayList<Integer> freqInRange(int[] arr, int[][] queries) {
        // code here
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        for(int i = 0; i < n; i++){
            hm.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }
        for(int[] q : queries){
            int l = q[0];
            int r = q[1];
            int x = q[2];
            int cnt = 0;
            if(hm.containsKey(x))
            for(int k : hm.get(x)){
                if(k >= l && k <= r)cnt++;
            }
            res.add(cnt);
        }
        return res;
    }
}