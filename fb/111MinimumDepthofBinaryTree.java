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
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        Queue<Depth> q = new LinkedList();
        q.offer(new Depth(root, 1));
        while(!q.isEmpty()){
            Depth d = q.poll();
            if(d.node.left == null && d.node.right == null)
                return d.depth;
            if(d.node.left != null)
                q.offer(new Depth(d.node.left, d.depth+1));
            if(d.node.right != null)
                q.offer(new Depth(d.node.right, d.depth+1));
        }
        return -1;
    }
    
}
class Depth{
    TreeNode node;
    int depth;
    Depth(TreeNode t, int d){node = t; depth = d;}
}
