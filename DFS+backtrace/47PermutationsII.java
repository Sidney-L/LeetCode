class Solution {
    private List<List<Integer>> ans;
    private List<Boolean> position;
    private List<Integer> path;
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new LinkedList<List<Integer>>();
        position = new LinkedList<Boolean>();
        path = new LinkedList<Integer>();
        for(int i = 0; i < nums.length; i++) {
            position.add(false);
            path.add(-1);
        }
        Arrays.sort(nums);
        dfs(nums, 0, 0);
        return ans;
        
    }
    
    private void dfs(int[] nums, int n, int start) {
        if(n == nums.length) {
            List<Integer> temp = new LinkedList<Integer>();
            temp.addAll(path);
            ans.add(temp);
        }
        for(int i = start; i < nums.length; i++) {
            if(!position.get(i)) {
                position.set(i, true);
                path.set(i, nums[n]);
                if(n+1 < nums.length && nums[n+1]!=nums[n]) {
                    dfs(nums, n+1, 0);
                }
                else {
                    dfs(nums, n+1, i+1);
                }
                position.set(i, false);
            }
        }
    }
}
