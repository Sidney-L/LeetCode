/*
 // Definition for a Node.
 class Node {
 public int val;
 public Node next;
 
 public Node() {}
 
 public Node(int _val,Node _next) {
 val = _val;
 next = _next;
 }
 };
 */
class Solution {
    public Node insert(Node head, int insertVal) {
        if(head == null){
            Node n = new Node();
            n.val = insertVal;
            n.next = n;
            return n;
        }
        else{
            Node cur = head;
            Node brk = head;
            do{
                if(cur.val > cur.next.val)
                    brk = cur;
                if(cur.val <= insertVal && cur.next.val >= insertVal)
                    break;
                else{
                    cur = cur.next;
                }
            }while(cur!=head);
            /*
             while(cur!=head){
             if(cur.val > cur.next.val)
             brk = cur;
             if(cur.val <= insertVal && cur.next.val >= insertVal)
             break;
             else{
             cur = cur.next;
             }
             }
             */
            if(cur == head){
                brk.next = new Node(insertVal, brk.next);
            }
            else{
                cur.next = new Node(insertVal, cur.next);
            }
        }
        return head;
    }
}
