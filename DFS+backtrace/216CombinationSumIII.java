class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new LinkedList<List<Integer>>();
        dfs(k,n,1, new LinkedList());
        return ans;
    }
    
    private void dfs(int k, int n, int index, List<Integer> path){
        LinkedList l = new LinkedList();
        l.addAll(path);
        if(k == 0) {
            if(n == 0)
                ans.add(l);
            return;
        }
        
        for(int i = index; i < 10; i++) {
            if(n>=i) {
                l.add(i);
                dfs(k-1, n-i, i+1, l);
                l.removeLast();
            }
            else {
                break;
            }
        }
    }
}
