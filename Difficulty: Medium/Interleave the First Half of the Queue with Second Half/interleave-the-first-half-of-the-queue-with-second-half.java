class Solution {
    public void rearrangeQueue(Queue<Integer> q) {
        // code here
        Queue<Integer> e = new LinkedList<>();
        Queue<Integer> o = new LinkedList<>();
        boolean f = true;
        int n = q.size();
        for(int i = 0; i < (n+1)/2; i++){
            e.add(q.remove());
        }
        while(!q.isEmpty())o.add(q.remove());
        f = true;
        while(!e.isEmpty() || !o.isEmpty()){
            if(f)q.add(e.remove());
            else if(!o.isEmpty()) q.add(o.remove());
            f = !f;
        }
    }
}
