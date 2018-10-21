class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int cur = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++){
            while(i!=0 && i < nums.length && nums[i] == nums[i-1]){
                i++;
            }
            if(i < nums.length) {
                count++;
                nums[cur++] = nums[i];
            }
        }
        return count;
    }
}
