class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        dfs(new LinkedList<Integer>(), 0, nums, ans);
        return ans;
    }
    private void dfs(List<Integer> cur, int index, int[] nums, List<List<Integer>> ans){
        if(cur.size() > 1)
            ans.add(new LinkedList<Integer>(cur));
        Set<Integer> used = new HashSet<Integer>();
        for(int i = index; i < nums.length; i++){
            if(used.contains(nums[i]))
                continue;
            if(cur.size()==0 || nums[i] >= ((LinkedList<Integer>)cur).peekLast()){
                cur.add(nums[i]);
                used.add(nums[i]);
                dfs(cur, i+1, nums, ans);
                ((LinkedList<Integer>)cur).removeLast();
            }
        }
    }
}
