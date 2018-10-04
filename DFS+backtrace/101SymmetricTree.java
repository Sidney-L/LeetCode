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
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        return dfs(root.left, root.right);
    }
    
    private boolean dfs(TreeNode left, TreeNode right){
        if(left == null || right == null)
            return left == null && right == null;
        else{
            return left.val == right.val && dfs(left.left, right.right) && dfs(left.right, right.left);
        }
    }
}
