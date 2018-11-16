class Solution {
    public boolean splitArray(int[] nums) {
        if(nums.length < 7)
            return false;
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for(int i = 1; i < nums.length; i++)
            sum[i]+=sum[i-1]+nums[i];
        for(int j = 3; j < nums.length-3; j++){
            HashSet<Integer> summ = new HashSet<Integer>();
            for(int i = 1; i < j-1; i++){
                if(sum[i-1] == sum[j-1] - sum[i])
                    summ.add(sum[i-1]);
            }
            for(int k = j + 2; k < nums.length - 1; k++){
                if(sum[nums.length-1] - sum[k] == sum[k-1] - sum[j] && summ.contains(sum[nums.length-1] - sum[k]))
                    return true;
            }
        }
        return false;
    }
}