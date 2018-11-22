/*
 // Definition for a Node.
 class Node {
 public int val;
 public Node left;
 public Node right;
 
 public Node() {}
 
 public Node(int _val,Node _left,Node _right) {
 val = _val;
 left = _left;
 right = _right;
 }
 };
 */
class Solution {
    public Node treeToDoublyList(Node root) {//traverse in-order
        Stack<Node> st = new Stack();
        if(root == null)
            return root;
        boolean headflag = true;
        Node head = null;
        Node cur = root;
        Node prev = null;
        while(cur!= null || !st.isEmpty()){
            while(cur!=null){
                st.push(cur);
                cur = cur.left;
            }
            cur = st.pop();
            if(headflag){
                headflag = false;
                head = cur;
            }
            cur.left = prev;
            if(prev!= null)
                prev.right = cur;
            prev = cur;
            cur = cur.right;
        }
        head.left = prev;
        prev.right = head;
        return head;
    }
    
}
