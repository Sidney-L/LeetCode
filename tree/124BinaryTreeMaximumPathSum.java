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
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        dfs(root);
        return ans;
    }
    
    private int dfs(TreeNode root){
        if(root == null)
            return 0;
        int vol = Math.max(0,dfs(root.left));//if negative value, then do not add the sub-tree path
        int vor = Math.max(0,dfs(root.right));
        ans = Math.max(ans, vol+vor+root.val);
        return Math.max(vol, vor) + root.val;
    }
}
