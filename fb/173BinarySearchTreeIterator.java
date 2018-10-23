/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
    Stack<TreeNode> st = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        TreeNode cur = root;
        while(cur!=null){
            st.push(cur);
            cur = cur.left;
        }
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !st.isEmpty();
    }
    
    /** @return the next smallest number */
    public int next() {
        TreeNode cur = st.pop();
        int value = cur.val;
        cur = cur.right;
        while(cur!=null){
            st.push(cur);
            cur = cur.left;
        }
        return value;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
