class Solution {
    public String findLongestWord(String s, List<String> d) {
        // code here
        Collections.sort(d, (a, b) -> a.length() == b.length() ? find(a, b) : a.length() - b.length());
        int n = d.size();
        for(int i = n-1; i >= 0; i--){
            if(isSubSeq(s, d.get(i)))return d.get(i);
        }
        return "";
    }
    boolean isSubSeq(String s, String d){
        int n = s.length();
        int m = d.length();
        
        // int i = 0;
        int j = 0;
        
        for(int i = 0; i < n; i++){
            if(d.charAt(j) == s.charAt(i))j++;
            if(j == m)return true;
        }
        return false;
    }
    int find(String a, String b){
        int n = a.length();
        
        for(int i = 0; i < n; i++){
            if(a.charAt(i) < b.charAt(i))return 1;
            else if(a.charAt(i) > b.charAt(i)) return -1;
        }
        return 0;
    }
}