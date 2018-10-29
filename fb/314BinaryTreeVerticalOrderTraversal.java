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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Queue<TreeNode> que =  new LinkedList<TreeNode>();
        Queue<Integer> col = new LinkedList<Integer>();
        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if(root == null)
            return ans;
        int min = 0;
        int max = 0;
        que.add(root);
        col.add(0);
        while(!que.isEmpty()){
            TreeNode cur = que.poll();
            int column = col.poll();
            if(!map.containsKey(column))
                map.put(column, new LinkedList());
            map.get(column).add(cur.val);
            if(cur.left!=null){
                que.add(cur.left);
                col.add(column - 1);
                min = Math.min(column-1, min);
            }
            if(cur.right!=null){
                que.add(cur.right);
                col.add(column + 1);
                max = Math.max(column + 1, max);
            }
        }
        
        for(int i = min; i<= max; i++){
            if(map.containsKey(i))
                ans.add(map.get(i));
        }
        return ans;
    }
}
