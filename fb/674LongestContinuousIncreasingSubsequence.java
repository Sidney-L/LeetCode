class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length == 0)
            return 0;
        //int[] dp = new int[nums.length];
        int max = 1;
        int temp = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] > nums[i-1]){
                temp++;
            }
            else{
                max = Math.max(temp, max);
                temp = 1;
            }
        }
        max = Math.max(temp, max);
        return max;
    }
}
