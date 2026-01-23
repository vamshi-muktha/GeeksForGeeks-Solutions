// import java.util.*;

class Solution {
    public ArrayList<Integer> nextFreqGreater(int[] arr) {
        // code here
        int n = arr.length;
        
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < n; i++){
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }
        Stack<Integer> s = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        res.add(-1);
        s.push(arr[n-1]);
        for(int i = n-2; i >= 0; i--){
            while(!s.isEmpty() && hm.get(s.peek()) <= hm.get(arr[i])){
                s.pop();
            }
            res.add(s.isEmpty() ? -1 : s.peek());
            s.push(arr[i]);
        }
        Collections.reverse(res);
        return res;
    }
}