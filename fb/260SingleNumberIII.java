class Solution {
    public int[] singleNumber(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum ^= nums[i];
        }
        int count = 0;
        while((sum & 1) == 0){
            sum >>= 1;
            count++;
        }
        int[] ans = new int[2];
        int mask = 1<<count;
        for(int e: nums){
            if((e & mask) == 0)
                ans[0] ^= e;
            else
                ans[1] ^= e;
        }
        return ans;
    }
}
