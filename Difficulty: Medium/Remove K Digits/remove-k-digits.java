class Solution {
    public String removeKdig(String str, int k) {
        int n = str.length();
        Stack<Integer> s = new Stack<>();
        if(n == k)return "0";
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < n; i++){
            while(!s.isEmpty() && s.peek() > Character.getNumericValue(str.charAt(i)) && k > 0){
                s.pop();
                k--;
            }
            s.push(Character.getNumericValue(str.charAt(i)));
        }
        while(!s.isEmpty()){
            res.append(s.pop());
        }
        String ans = res.reverse().toString();
        int i = 0;
        while(i < ans.length() && Character.getNumericValue(ans.charAt(i)) == 0 )i++;
        ans = ans.substring(i);
        if(ans.length() - k < 0)return "0";
        
        return ans.substring(0, ans.length() - k).length() == 0 ? "0" : ans.substring(0, ans.length() - k);
        
    }
}