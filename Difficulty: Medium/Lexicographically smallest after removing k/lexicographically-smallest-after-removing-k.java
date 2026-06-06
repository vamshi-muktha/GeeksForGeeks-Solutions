class Solution {
    public String lexicographicallySmallest(String s, int k) {
        // code here
        int n = s.length();
        if(isPower(n))k /= 2;
        else k *= 2;
        if(k >= n)return "-1";
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(st.isEmpty() || st.peek() < ch)st.push(ch);
            else{
                while(!st.isEmpty() && st.peek() > ch && k > 0){
                    st.pop();
                    k--;
                }
                st.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : st) {
            sb.append(ch);
        }

        String result = sb.toString();
        result = result.substring(0, result.length() - k);
        return result;
    }
    boolean isPower(int n){
        return (n & n-1) == 0;
    }
}