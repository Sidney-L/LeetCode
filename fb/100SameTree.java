/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null)
            return q == null;
        if(q==null)
            return p == null;
        Queue<TreeNode> q1 = new LinkedList();
        Queue<TreeNode> q2 = new LinkedList();
        q1.offer(p);
        q2.offer(q);
        while(!q1.isEmpty() && !q2.isEmpty()){
            TreeNode root1 = q1.poll();
            TreeNode root2 = q2.poll();
            if(root1.val!=root2.val)
                return false;
            if(root1.left!=null && root2.left!=null){
                q1.offer(root1.left);
                q2.offer(root2.left);
            }
            else if(root1.left==null && root2.left==null);
            else return false;
            if(root1.right!=null && root2.right!=null){
                q1.offer(root1.right);
                q2.offer(root2.right);
            }
            else if(root1.right==null && root2.right==null);
            else return false;
        }
        
        return q1.isEmpty() && q2.isEmpty();
    }
}
