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
    private List<TreeNode> path1, path2;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        path1 = new LinkedList<TreeNode>();
        path2 = new LinkedList<TreeNode>();
        dfs(root, p, q, new LinkedList<TreeNode>());
        int index = 0;
        for(index = 0; index < path1.size()&& index < path2.size(); index++) {
            if(path1.get(index)!=path2.get(index))
                break;
        }
        if(index != path1.size() && index!=path2.size())
            return path1.get(index-1);
        else
            return path1.get(index-1);
    }
    
    private void dfs(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> path) {
        if(root == null)
            return;
        path.add(root);
        if(root == p) {
            path1.addAll(path);
        }
        if(root == q) {
            path2.addAll(path);
        }
        dfs(root.left, p, q, path);
        dfs(root.right, p, q, path);
        path.remove(path.size()-1);
    }
}
