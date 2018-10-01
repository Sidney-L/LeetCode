class Solution {
    private List<String> ans;
    public List<String> generateParenthesis(int n) {
        ans = new LinkedList<String>();
        if(n == 0){
            return ans;
        }
        dfs(0, 0, n, "");
        return ans;
    }
    
    private void dfs(int l, int r, int n, String cur){
        if(l == n && r == n){
            ans.add(cur);
        }
        if(l < n){
            dfs(l+1, r, n, cur + "(");
            
        }
        if(r < l){
            dfs(l, r+1, n, cur + ")");
        }
    }
}
