class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            while(i != 0 && i < nums.length && nums[i] == nums[i-1]) {
                i++;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while(l < r) {
                if(nums[i]+nums[l]+nums[r]==0) {
                    LinkedList<Integer> temp = new LinkedList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    ans.add(temp);
                    do{l++;}while(l < r && nums[l] == nums[l-1]);
                    do{r--;}while(l < r && nums[r] == nums[r+1]);
                }
                else if(nums[i]+nums[l]+nums[r] < 0) {
                    do{l++;}while(l < r && nums[l] == nums[l-1]);
                }
                else {
                    do{r--;}while(l < r && nums[r] == nums[r+1]);
                }
            }
        }
        return ans;
    }
}
