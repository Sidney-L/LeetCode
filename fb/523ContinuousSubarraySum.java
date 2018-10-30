class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = 0;
        int[] prefixSum = new int[nums.length];
        if(nums.length <= 1)
            return false;
        if(nums.length == 2){
            if(k==0)
                return nums[0]+nums[1] == 0;
            return (nums[0]+nums[1])%k == 0;
        }
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            prefixSum[i] = sum;
            for(int j = 0; j < i-1; j++){
                if(k==0 && sum == 0)
                    return true;
                else if(k!=0 && (sum - prefixSum[j]) % k ==0)
                    return true;
                else if(k!= 0&&sum % k == 0)
                    return true;
            }
            /* while(ite.hasNext()){
             Map.Entry pair = (Map.Entry)ite.next();
             if((sum - (Integer)pair.getValue())% k == 0)
             return true;
             }
             */
        }
        return false;
    }
}
