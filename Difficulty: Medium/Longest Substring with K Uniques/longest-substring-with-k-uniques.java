class Solution {
    public int longestKSubstr(String s, int k) {
        // code here
        int n = s.length();
        int i = 0;
        int j = 0;
        int max = -1;
        HashMap<Character, Integer> hm = new HashMap<>();
        while(j < n){
            hm.put(s.charAt(j), hm.getOrDefault(s.charAt(j), 0) + 1);
            // for(char ch : hm.keySet())System.out.print("(" + ch + " " + hm.get(ch) + ")");
            // System.out.println();
            if(hm.size() == k){
                max = Math.max(max, j - i + 1);
            }
            while(i < j && hm.size() > k){
                if(hm.get(s.charAt(i)) == 1)hm.remove(s.charAt(i));
                else hm.put(s.charAt(i), hm.get(s.charAt(i)) - 1);
                i++;
            }
            j++;
        }
        return max;
    }
}