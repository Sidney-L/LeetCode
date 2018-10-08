/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        while(root != null) {
            TreeLinkNode dummy = new TreeLinkNode(0);
            TreeLinkNode tail = dummy;
            while(root != null) {
                if(root.left != null) {
                    tail.next = root.left;
                    tail = tail.next;
                }
                if(root.right != null) {
                    tail.next = root.right;
                    tail = tail.next;
                }
                root = root.next;
            }
            root = dummy.next;
        }
    }
}
