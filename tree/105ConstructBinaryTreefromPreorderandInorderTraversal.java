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
    private HashMap<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return dfs(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
    
    private TreeNode dfs(int[] pre, int[] in, int prel, int prer, int inl, int inr){
        if(prel > prer)
            return null;
        TreeNode root = new TreeNode(pre[prel]);
        int k = map.get(pre[prel]) - inl;
        root.left = dfs(pre, in, prel+1, prel+k, inl, inl+k-1);
        root.right = dfs(pre, in, prel+k+1, prer, inl+k+1, inr);
        return root;
    }
}
