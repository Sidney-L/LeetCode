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
    private List<List<Integer>> tra;
    public List<List<Integer>> levelOrder(TreeNode root) {
        tra = new LinkedList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root == null)
            return tra;
        q.add(root);
        while(!q.isEmpty()) {
            Queue<TreeNode> nq = new LinkedList<TreeNode>();
            List<Integer> path = new LinkedList<Integer>();
            for(TreeNode tn: q) {
                if(tn.left!=null)
                    nq.add(tn.left);
                if(tn.right!=null)
                    nq.add(tn.right);
                path.add(tn.val);
            }
            tra.add(path);
            q = nq;
        }
        return tra;
    }
}
