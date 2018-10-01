class Solution {
    private List<List<Integer>> perm;
    private List<Boolean> s;
    private List<Integer> path;
    
    public List<List<Integer>> permute(int[] nums) {
        perm = new LinkedList<List<Integer>>();
        s = new LinkedList<Boolean>();
        path = new LinkedList<Integer>();
        for(int i = 0; i < nums.length; i++){
            s.add(false);
        }
        dfs(nums, 0);
        return perm;
    }
    
    private void dfs(int[] nums, int n){
        if(n == nums.length){
            List<Integer> c = new LinkedList<Integer>();
            c.addAll(path);
            perm.add(c);
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!s.get(i)){
                s.set(i, true);
                path.add(nums[i]);
                dfs(nums, n+1);
                s.set(i, false);
                path.remove(path.size()-1);
            }
        }
    }
}
