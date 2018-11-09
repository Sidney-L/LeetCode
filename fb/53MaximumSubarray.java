class Solution {
    public int maxSubArray(int[] nums) {
        /*
         if(nums.length == 0)
         return 0;
         int[] dp = new int[nums.length];
         dp[0] = nums[0];
         int max = nums[0];
         for(int i = 1; i<nums.length; i++){
         dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
         max = Math.max(max, dp[i]);
         }
         return max;
         */
        if(nums.length == 0)
            return 0;
        return divideAndConquer(nums, 0, nums.length-1);
        
    }
    private int divideAndConquer(int nums[], int l, int r){
        if(l==r)
            return nums[l];
        int mid = (l + r)/2;
        int lmax = nums[mid];
        int rmax = nums[mid+1];
        int lsum = 0;
        int rsum = 0;
        for(int i = mid; i>=l; i--){
            lsum += nums[i];
            lmax = Math.max(lmax, lsum);
        }
        for(int i = mid+1; i<=r; i++){
            rsum += nums[i];
            rmax = Math.max(rmax, rsum);
        }
        return Math.max(divideAndConquer(nums, l, mid), Math.max(lmax+rmax, divideAndConquer(nums, mid+1, r)));
    }
}
