class Solution {
    \*
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int[] map = new int[nums.length];
        for(int i = 0; i < map.length; i++){
            map[i] = 1;
        }
        int ans = 1;
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    map[i] = Math.max(map[i], map[j]+1);
                }
            }
            if(ans < map[i])
                ans = map[i];
        }
        return ans;
    }
    */
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        int ans = 1;
        int[] dp = new int[nums.length+1];
        dp[1] = nums[0];
        for(int i = 1; i < nums.length; i++){
            int l = 1;
            int r = ans;
            while(l <= r){
                int mid = (l + r)/2;
                if(dp[mid] < nums[i])
                    l = mid + 1;
                else
                    r = mid - 1;
            }
            dp[l] = nums[i];
            ans = Math.max(ans, l);
        }
        return ans;
    }
}
