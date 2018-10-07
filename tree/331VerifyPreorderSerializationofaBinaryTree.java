class Solution {
    private boolean ans;
    private Integer index;
    public boolean isValidSerialization(String preorder) {
        ans = true;
        index = 0;
        preorder += ",";
        dfs(preorder);
        return ans && index == preorder.length();
    }
    private void dfs(String preorder) {
        if(index == preorder.length()) {
            ans = false;
            return;
        }
        if(preorder.charAt(index) == '#') {
            index += 2;
            return;
        }
        while(preorder.charAt(index) != ',')
            index++;
        index++;
        dfs(preorder);//left
        dfs(preorder);//right
    }
}
