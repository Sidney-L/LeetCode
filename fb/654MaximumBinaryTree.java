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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return dfs(nums, 0, nums.length-1);
    }
    
    private TreeNode dfs(int[] nums, int l, int r){
        if(l==r)
            return new TreeNode(nums[l]);
        int index = l;
        int max = nums[l];
        for(int i = l; i <= r; i++){
            if(max < nums[i]){
                index = i;
                max = nums[i];
            }
        }
        TreeNode root = new TreeNode(max);
        if(l<=index-1)
            root.left = dfs(nums, l, index-1);
        if(index+1 <= r)
            root.right = dfs(nums, index+1, r);
        return root;
    }
}
