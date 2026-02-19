class Solution {
    public ArrayList<Integer> missingRange(int[] arr, int low, int high) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        HashSet<Integer> hs = new HashSet<>();
        for(int i : arr)hs.add(i);
        for(int i = low; i <= high; i++){
            if(!hs.contains(i))res.add(i);
        }
        Collections.sort(res);
        return res;
    }
}