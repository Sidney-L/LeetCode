class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new LinkedList();
        for(int i = 0; i < nums.length; i++){
            while(i!=0 && i < nums.length&& nums[i]==nums[i-1]) i++;
            for(int j = i+1; j < nums.length; j++){
                while(j!=i+1&&j < nums.length&&nums[j]==nums[j-1]) j++;
                int l = j+1;
                int r = nums.length-1;
                while(l < r){
                    if(nums[i]+nums[j]+nums[l] + nums[r] == target){
                        List<Integer> temp = new LinkedList();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[l]);
                        temp.add(nums[r]);
                        ans.add(temp);
                        do{l++;}while(l<r&&nums[l] == nums[l-1]);
                        do{r--;}while(l<r&&nums[r] == nums[r+1]);
                    }
                    else if(nums[i]+nums[j]+nums[l] + nums[r] < target){
                        do{l++;}while(l<r&&nums[l] == nums[l-1]);
                    }
                    else
                        do{r--;}while(l<r&&nums[r] == nums[r+1]);
                }
            }
        }
        return ans;
    }
}
