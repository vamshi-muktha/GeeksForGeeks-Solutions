class Solution {
    public int solve(int n, String s) {
        // code here
        int res = 0;
        HashSet<Character> hs = new HashSet<>();
        HashSet<Character> idle = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(hs.size() < n && !hs.contains(ch) && !idle.contains(ch))hs.add(ch);
            else if(hs.contains(ch)) hs.remove(ch);
            else if(idle.contains(ch)){
                res++;
            }
            else idle.add(ch);
        }
        return res;
    }
}
