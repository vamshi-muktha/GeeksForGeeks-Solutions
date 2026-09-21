/* Structure of binary tree Node
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/

class Solution {
    public boolean areAnagrams(Node root1, Node root2) {
        // code here
        ArrayList<ArrayList<Integer>> al1 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> al2 = new ArrayList<>();
        
        find(root1, al1);
        find(root2, al2);
        if(al1.size() != al2.size())return false;
        for(int i = 0; i < al1.size(); i++){
            if(!isAnagram(al1.get(i), al2.get(i)))return false;
        }
        return true;
    }
    void find(Node root, ArrayList<ArrayList<Integer>> al){
        if(root == null)return;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int n = q.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = 0; i < n; i++){
                Node curr = q.remove();
                temp.add(curr.data);
                if(curr.left != null)q.add(curr.left);
                if(curr.right != null)q.add(curr.right); 
            }
            al.add(temp);
        }
    }
    boolean isAnagram(ArrayList<Integer> a1, ArrayList<Integer> a2){
        int n = a1.size();
        int m = a2.size();
        
        if(n != m)return false;
        
        Collections.sort(a1);
        Collections.sort(a2);
        
        for(int i = 0; i < n; i++)if(!a1.get(i).equals(a2.get(i)))return false;
        return true;
    }
}
