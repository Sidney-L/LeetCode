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
    public int closestValue(TreeNode root, double target) {
        TreeNode cur = root;
        TreeNode prev = cur;
        TreeNode prevprev = prev;
        int s = (int)Math.round(target);
        while(cur!=null){
            if(cur.val == s)
                return cur.val;
            else if(cur.val > s){
                prevprev = prev;
                prev = cur;
                cur = cur.left;
            }
            else{
                prevprev = prev;
                prev = cur;
                cur = cur.right;
            }
        }
        if(Math.abs(target-prev.val) > Math.abs(target-prevprev.val))
            return prevprev.val;
        else
            return prev.val;
    }
}
