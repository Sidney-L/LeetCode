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
     public TreeNode invertTree(TreeNode root) {
     if(root == null)
     return root;
     invertTree(root.left);
     invertTree(root.right);
     TreeNode temp = root.left;
     root.left = root.right;
     root.right = temp;
     return root;
     }
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return root;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode cur = q.poll();
            TreeNode temp = cur.left;
            cur.left = cur.right;
            cur.right = temp;
            if(cur.left!=null)
                q.offer(cur.left);
            if(cur.right!=null)
                q.offer(cur.right);
        }
        return root;
    }
}
