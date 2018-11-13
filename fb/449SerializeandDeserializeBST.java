/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {//pre-order tranverse
        if(root == null)
            return "NULL";
        Stack<TreeNode> q = new Stack<TreeNode>();
        q.push(root);
        StringBuffer sb = new StringBuffer();
        while(!q.isEmpty()){
            TreeNode cur = q.pop();
            sb.append(""+cur.val).append(",");
            if(cur.right!=null)
                q.push(cur.right);
            if(cur.left!=null)
                q.push(cur.left);
        }
        return sb.toString();
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("NULL"))
            return null;
        String[] s = data.split(",");
        Queue<Integer> q = new LinkedList<Integer>();
        for(String e: s){
            q.add(Integer.parseInt(e));
        }
        return construct(q);
    }
    
    private TreeNode construct(Queue<Integer> q){
        if(q.isEmpty())
            return null;
        TreeNode root = new TreeNode(q.poll());
        Queue<Integer> lq = new LinkedList<Integer>();
        while(!q.isEmpty() && q.peek() < root.val){
            lq.add(q.poll());
        }
        root.left = construct(lq);
        root.right = construct(q);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
