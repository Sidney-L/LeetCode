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
    public void flatten(TreeNode root) {
        postorder(root);
    }
    private TreeNode postorder(TreeNode root){//return the current tail
        if(root == null)
            return root;
        if(root.left == null && root.right == null){
            return root;
        }
        else if(root.left == null && root.right != null)
            return postorder(root.right);
        TreeNode temp = root.right;
        TreeNode ltail = postorder(root.left);
        root.right = root.left;
        ltail.right = temp;
        root.left = null;
        TreeNode ans = postorder(temp);
        return ans==null?ltail:ans;
    }
}
