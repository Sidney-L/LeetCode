class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] max = new int[n];
        max[0] = nums[0];
        int ans = nums[0];
        for(int i = 1; i < n; i++){
            max[i] = Math.max(max[i-1] + nums[i], nums[i]);
            ans = Math.max(max[i], ans);
        }
        return ans;
    }
}
