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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new LinkedList<Integer>();
        if(root == null)
            return ans;
        List<TreeNode> list = new LinkedList<TreeNode>();
        list.add(root);
        int l = 0;
        int r = 0;
        while(l <= r){
            ans.add(list.get(l).val);
            int count = 0;
            for(int i = l; i <= r; i++){
                if(list.get(i).right!=null){
                    list.add(list.get(i).right);
                    count++;
                }
                if(list.get(i).left!=null){
                    list.add(list.get(i).left);
                    count++;
                }
            }
            l = r + 1;
            r = l + count - 1;
        }
        return ans;
    }
}
