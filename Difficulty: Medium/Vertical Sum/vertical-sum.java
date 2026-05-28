/* Structure of binary tree node
class Node{
public:
    int data;
    Node left, right;
    Node(int item)
    {
        data = item;
        left = right = null;
    }
}
*/
class pair{
    Node n;
    int x;
    pair(Node n, int x){
        this.n = n;
        this.x = x;
    }
}
class Solution {
    public ArrayList<Integer> verticalSum(Node root) {
        // code here
        HashMap<Integer, Integer> hm = new HashMap<>();
        int min = 0;
        int max = 0;
        ArrayList<Integer> al = new ArrayList<>();
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(root, 0));
        while(!q.isEmpty()){
            pair curr = q.remove();
            Node n = curr.n;
            int x = curr.x;
            hm.put(x, hm.getOrDefault(x, 0) + n.data);
            if(n.left != null){
                q.add(new pair(n.left, x - 1));
                min = Math.min(min, x - 1);
            }
            if(n.right != null){
                q.add(new pair(n.right, x + 1));
                max = Math.max(max, x + 1);
            }
        }
         
        for(int i = min; i <= max; i++){
            al.add(hm.get(i));
        }
        return al;
    }
}