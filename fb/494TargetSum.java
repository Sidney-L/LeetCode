class Solution {
    /*
     int count;
     public int findTargetSumWays(int[] nums, int S) {
     count = 0;
     dfs(nums, S, 0, 0);
     return count;
     }
     private void dfs(int[] nums, int S, int index, int sum){
     if(index == nums.length){
     if(sum == S)
     count++;
     return;
     }
     dfs(nums, S, index+1, sum + nums[index]);
     dfs(nums, S, index+1, sum - nums[index]);
     */
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int i =0; i < nums.length; i++)
            sum+=nums[i];
        int[][] dp = new int[nums.length+1][2*sum+1];
        for(int i = 0; i < 2*sum+1; i++){
            dp[0][i] = 0;
        }
        dp[0][sum] = 1;
        for(int i = 1; i <= nums.length; i++){
            for(int j = 0; j < 2*sum+1; j++){
                dp[i][j] = ((j-nums[i-1] >=0&&j-nums[i-1] < 2*sum+1)?dp[i-1][j-nums[i-1]]:0)
                + ((j+nums[i-1] >=0&&j+nums[i-1] < 2*sum+1)?dp[i-1][j+nums[i-1]]:0);
            }
        }
        return (S+sum >= 0 && S+sum < 2*sum+1)? dp[nums.length][S+sum]:0;
    }
}
