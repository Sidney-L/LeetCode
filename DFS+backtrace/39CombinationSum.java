class Solution {
private List<List<Integer>> ans;
private List<Integer> path;

public List<List<Integer>> combinationSum(int[] candidates, int target) {
ans = new LinkedList<List<Integer>>();
Arrays.sort(candidates);
dfs(candidates, target, 0, 0, new LinkedList());
return ans;
}

private void dfs(int[] nums, int target, int index, int sum, List<Integer> l){
List<Integer> temp = new LinkedList<Integer>();
temp.addAll(l);
int sumTemp  = sum;
if(sumTemp == target){
ans.add(temp);
return;
}
if(index == nums.length){
return;
}
if(sum + nums[index] > target){
return;
}
while(sum <= target){
dfs(nums, target, index+1, sum, temp);
sum += nums[index];
temp.add(nums[index]);

}
}
