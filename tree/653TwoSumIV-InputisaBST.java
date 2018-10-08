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
    private List<Integer> bst;
    public boolean findTarget(TreeNode root, int k) {
        bst = new LinkedList<Integer>();
        inorder(root);
        int length = bst.size();
        for(int i = 0, j = length-1; i<j;) {
            if(bst.get(i) + bst.get(j) == k)
                return true;
            else if(bst.get(i) + bst.get(j) > k) {
                j--;
                continue;
            }
            else {
                i++;
                continue;
            }
        }
        return false;
    }
    
    private void inorder(TreeNode root){
        if(root == null)
            return;
        inorder(root.left);
        bst.add(root.val);
        inorder(root.right);
    }
}
