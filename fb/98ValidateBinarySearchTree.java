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
    public boolean isValidBST(TreeNode root) {
        /*
         if (root == null)
         return true;
         Queue<TreeNode> que = new LinkedList<TreeNode>();
         que.add(root);
         while(!que.isEmpty()){
         TreeNode cur = que.poll();
         if(cur.left != null && cur.left.val >= cur.val){
         return false;
         }
         else if (cur.right!= null && cur.right.val <= cur.val){
         return false;
         }
         if(cur.left!=null)
         que.add(cur.left);
         if(cur.right!=null)
         que.add(cur.right);
         }
         return true;
         */
        ArrayList<Integer> max = new ArrayList<Integer>();
        max.add(Integer.MIN_VALUE);
        ArrayList<Integer> min = new ArrayList<Integer>();
        min.add(Integer.MAX_VALUE);
        if(root == null)
            return true;
        return dfs(root, max, min);
    }
    private boolean dfs(TreeNode root, ArrayList<Integer> max, ArrayList<Integer> min){
        max.set(0,root.val);
        min.set(0,root.val);
        if(root.left != null){
            ArrayList<Integer> maxNow = new ArrayList<Integer>();
            maxNow.add(Integer.MIN_VALUE);
            ArrayList<Integer> minNow = new ArrayList<Integer>();
            minNow.add(Integer.MAX_VALUE);
            if(!dfs(root.left, maxNow, minNow))
                return false;
            if(maxNow.get(0) >= root.val)
                return false;
            min.set(0,Math.min(min.get(0), minNow.get(0)));
        }
        if(root.right != null){
            ArrayList<Integer> maxNow = new ArrayList<Integer>();
            maxNow.add(Integer.MIN_VALUE);
            ArrayList<Integer> minNow = new ArrayList<Integer>();
            minNow.add(Integer.MAX_VALUE);
            if(!dfs(root.right, maxNow, minNow))
                return false;
            if(minNow.get(0) <= root.val)
                return false;
            max.set(0,Math.max(max.get(0), maxNow.get(0)));
        }
        return true;
    }
}
