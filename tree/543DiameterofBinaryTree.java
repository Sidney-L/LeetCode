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
    private int ans;
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }
    
    private int dfs(TreeNode root){
        if(root == null)
            return -1;
        int lol = dfs(root.left);
        int lor = dfs(root.right);
        ans = Math.max(ans, lol + lor + 2);
        return Math.max(lol, lor) + 1;
    }
}
