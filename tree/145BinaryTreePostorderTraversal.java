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
    /*public List<Integer> postorderTraversal(TreeNode root) {
     List<Integer> ans = new LinkedList<Integer>();
     postOrder(root, ans);
     return ans;
     }
     
     private void postOrder(TreeNode root, List<Integer> ans){
     if(root == null){
     return;
     }
     else{
     if(root.left != null)
     postOrder(root.left, ans);
     if(root.right != null)
     postOrder(root.right, ans);
     ans.add(root.val);
     }
     }
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;
        TreeNode lastVisited = null;
        if(root == null)
            return ans;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.peek();
            if(cur.right == null || cur.right == lastVisited){
                ans.add(cur.val);
                lastVisited = cur;
                cur = null;
                stack.pop();
            }
            else{
                cur = cur.right;
            }
        }
        return ans;
    }
}
