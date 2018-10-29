class Solution {
    public int subarraySum(int[] nums, int k) {
        /*
         int n = nums.length;
         int [][] dp = new int[n][n];
         for(int i = 0; i < n; i++){
         dp[i][i] = nums[i];
         }
         for(int i = 0; i < n; i++){
         for(int j  = i+1; j < n; j++){
         dp[i][j] = dp[i][j-1] + nums[j];
         }
         }
         int count = 0;
         for(int i = 0; i < n; i++){
         for(int j  = i; j < n; j++){
         if(dp[i][j] == k)
         count++;
         }
         }
         return count;
         */
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int ans = 0;
        map.put(0, 1);
        int sum = 0;
        for(int e: nums){
            sum += e;
            if(map.containsKey(sum-k))
                ans+= map.get(sum - k);
            if(map.containsKey(sum))
                map.put(sum,map.get(sum)+1);
            else
                map.put(sum,1);
        }
        return ans;
    }
}
