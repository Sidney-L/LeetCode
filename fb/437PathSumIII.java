
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
    public int pathSum(TreeNode root, int sum) {
        if(root == null)
            return 0;
        return dfs(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    private int dfs(TreeNode root, int target){
        if(root == null)
            return 0;
        return (root.val == target? 1:0) +
        dfs(root.left, target-root.val) + dfs(root.right, target-root.val);
    }
}
