class Solution {
    private List<List<Integer>> ans;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new LinkedList<List<Integer>>();
        Arrays.sort(candidates);
        dfs(candidates, 0, new LinkedList(), target, 0);
        return ans;
    }
    
    
    private void dfs(int[] nums, int sum, List<Integer> l, int target, int index){
        List<Integer> temp = new LinkedList<Integer>();
        temp.addAll(l);
        if(sum == target){
            ans.add(temp);
            return;
        }
        if(index == nums.length)
            return;
        if(sum  > target){
            return;
        }
        for(int i = index + 1; i < nums.length; i++) {
            if(nums[i]!=nums[index]) {
                dfs(nums, sum, temp, target, i);
                break;
            }
        }
        temp.add(nums[index]);
        sum += nums[index];
        dfs(nums, sum, temp, target, index+1);
    }
}
