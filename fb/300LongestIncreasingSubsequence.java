class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0)
            return 0;
        int length = nums.length;
        int[] dp = new int[length];
        dp[0] = 1;
        for(int i = 1; i < length; i++){
            dp[i] = 1;
            for(int j = i-1; j >= 0; j--){
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[i],dp[j]+1);
            }
        }
        int max = dp[0];
        for(int i = 0; i < length; i++)
            max = Math.max(dp[i], max);
        return max;
    }
}
