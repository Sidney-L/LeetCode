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
    /*
     public boolean isSymmetric(TreeNode root) {
     if(root == null)
     return true;
     return dfs(root.left, root.right);
     }
     private boolean dfs(TreeNode left, TreeNode right){
     if(left == null || right == null)
     return left==null && right == null;
     return left.val == right.val && dfs(left.right, right.left) && dfs(left.left, right.right);
     }
     */
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root == null)
            return true;
        q.offer(root);
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode p1 = q.poll();
            TreeNode p2 = q.poll();
            if(p1.val != p2.val)
                return false;
            if( (p1.left == null) != (p2.right == null))
                return false;
            if(p1.left != null){
                q.offer(p1.left);
                q.offer(p2.right);
            }
            if( (p1.right == null) != (p2.left == null))
                return false;
            if(p1.right != null){
                q.offer(p1.right);
                q.offer(p2.left);
            }
        }
        return true;
    }
}
