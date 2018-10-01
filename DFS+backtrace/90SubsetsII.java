List<List<Integer>> ans;
List<Integer> temp;
public List<List<Integer>> subsets(int[] nums) {
ans = new LinkedList<List<Integer>>();
temp = new LinkedList<Integer>();
dfs(nums, 0);
return ans;
}

private void dfs(int[] nums, int index){
LinkedList<Integer> copy = new LinkedList<Integer>();
copy.addAll(temp);
ans.add(copy);
for(int i = index; i < nums.length; i++){
if(i > index && nums[i] == nums[i-1])
continue;
temp.add(nums[i]);
dfs(nums, i+1);
temp.remove(temp.size()-1);
}
}
