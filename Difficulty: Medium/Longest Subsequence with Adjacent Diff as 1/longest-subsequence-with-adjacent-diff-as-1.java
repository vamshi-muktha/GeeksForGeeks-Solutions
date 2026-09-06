class Solution {
    public int longestSubseq(int[] arr) {
        // code here
        int n = arr.length;
        // int[] temp = new int[n];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < n; i++){
            int x = arr[i];
            int len = 0;
            if(hm.containsKey(x + 1) || hm.containsKey(x - 1)){
                len = Math.max(hm.containsKey(x+1) ? hm.get(x+1) : 0, hm.containsKey(x-1) ? hm.get(x-1) : 0);
            }
            hm.put(arr[i], len+1);
        }
        int max = 0;
        for(int i : hm.keySet()){
            max = Math.max(max, hm.get(i));
        }
        return max;
    }
}
