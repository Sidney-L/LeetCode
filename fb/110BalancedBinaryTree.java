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
    public boolean isBalanced(TreeNode root) {
        int[] height = new int[1];
        return dfs(root, height);
    }
    private boolean dfs(TreeNode root, int[] height){
        if(root == null){
            height[0] = 0;
            return true;
        }
        int[] heightL = new int[1];
        int[] heightR = new int[1];
        if(!dfs(root.left,heightL))
            return false;
        if(!dfs(root.right,heightR))
            return false;
        height[0] = Math.max(heightL[0], heightR[0]) + 1;
        return Math.abs(heightL[0] - heightR[0]) <= 1;
    }
}
