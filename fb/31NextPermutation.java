class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length == 0 || nums.length == 1)
            return;
        for(int start = nums.length-2; start >= 0; start--){
            if(nums[start] < nums[start+1]){
                for(int end = start+1; end < nums.length; end++){
                    if(nums[end] <= nums[start]){
                        swap(end-1, start,nums);
                        reverse(start+1, nums.length-1,nums);
                        return;
                    }
                }
                swap(start, nums.length-1,nums);
                reverse(start+1, nums.length-1,nums);
                return;
            }
            else
                continue;
        }
        Arrays.sort(nums);
        return;
    }
    
    private void swap(int i1, int i2, int[] nums){
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
        return;
    }
    private void reverse(int i1, int i2, int[] nums){
        int temp;
        while(i1 < i2){
            temp = nums[i2];
            nums[i2] = nums[i1];
            nums[i1] = temp;
            i1++;
            i2--;
        }
    }
}
