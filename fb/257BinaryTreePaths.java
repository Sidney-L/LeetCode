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
    List<String> ans;
    public List<String> binaryTreePaths(TreeNode root) {
        ans = new LinkedList<String>();
        dfs(root, "");
        return ans;
    }
    
    private boolean dfs(TreeNode root, String s){
        if(root == null){
            return false;
        }
        else{
            s += "->";
            s += root.val;
            if(!dfs(root.left, s) & !dfs(root.right, s)){
                String temp = s.substring(2, s.length());
                ans.add(temp);
            }
            s = s.substring(0,s.length()-3);
            return true;
        }
    }
}
