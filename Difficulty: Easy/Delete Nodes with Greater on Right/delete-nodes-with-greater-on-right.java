/* Structure of linked list node
class Node {

    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/
class Solution {
    Node compute(Node head) {
        // code here
        
        head = reverse(head);
        Node prev = new Node(Integer.MAX_VALUE);
        prev.next = head;
        head = prev;
        Node temp = head.next;
        int max = 0;
        while(temp != null){
            if(temp.data < max){
                prev.next = temp.next;
            }
            else{
                prev = temp;
            }     
            max = Math.max(max, temp.data);

            temp = temp.next;
            
            
        }
        return reverse(head.next);
    }
    
    Node reverse(Node head){
        Node prev = null;
        Node temp = head;
        Node next;
        while(temp != null){
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        return prev;
    }
}