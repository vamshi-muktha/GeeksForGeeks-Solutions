class Solution {
    public static ArrayList<Integer> findUnion(int[] a, int[] b) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        Set<Integer> s = new HashSet<>();
        for(int i = 0; i < a.length; i++){
            s.add(a[i]);
        }
        
        
        
        
        
        for(int i = 0; i < b.length; i++){
            s.add(b[i]);
        }
        res.addAll(s);
        return res;
    }
}