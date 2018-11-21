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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;
        while((p.val > cur.val) == (q.val > cur.val) && p!=cur && q!=cur){
            if(p.val > cur.val){
                cur = cur.right;
            }
            else
                cur = cur.left;
        }
        return cur;
    }
}
