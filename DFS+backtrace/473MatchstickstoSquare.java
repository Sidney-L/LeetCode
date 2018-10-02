class Solution {
    int length = 0;
    public boolean makesquare(int[] nums) {
        if(nums.length == 0){
            return false;
        }
        int sum = 0;
        Integer[] numsObj = new Integer[nums.length];
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            numsObj[i] = nums[i];
        }
        length = sum/4;
        if(length * 4 != sum)
            return false;
        else{
            Arrays.sort(numsObj, Collections.reverseOrder());
            int[] subSum = new int[4];
            return dfs(numsObj, 0, subSum);
        }
    }
    
    private boolean dfs(Integer[] nums, int index, int[] subSum){
        if(subSum[0] == length && subSum[1] == length && subSum[2] == length){
            return true;
        }
        for(int i = 0; i < 4; i++){
            if(subSum[i] + nums[index] > length)
                continue;
            subSum[i] += nums[index];
            if(dfs(nums, index+1, subSum))
                return true;
            subSum[i] -= nums[index];
        }
        return false;
    }
}
