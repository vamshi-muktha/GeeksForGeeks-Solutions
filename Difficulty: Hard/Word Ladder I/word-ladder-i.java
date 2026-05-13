class Pair{
    String s;
    int i;
    Pair(String s, int i){
        this.s = s;
        this.i = i;
    }
}

class Solution {
    public int wordLadderLength(String st, String wt,
                                String[] wordList) {
        // Code here
        Set<String> s = new HashSet<>();
        for(String str : wordList)s.add(str);
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(st, 1));
        
        while(!q.isEmpty()){
            int n = q.size();
            for(int i = 0; i < n; i++){
                Pair p = q.remove();
                String str = p.s;
                if(str.equals(wt))return p.i;
                int lv = p.i;
                for(int k = 0; k < str.length(); k++){
                    for(char j = 'a'; j <= 'z'; j++){
                        StringBuilder sb = new StringBuilder(str);
                        sb.setCharAt(k, j);
                        String str1 = sb.toString();                
                        if(s.contains(str1)){
                            q.add(new Pair(str1, lv+1));
                            s.remove(str1);
                        }
                    }
                    
                }
            }
        }
        return 0;
    }
}