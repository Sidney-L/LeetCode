class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int count0 = 0;
        int index0 = -1;
        int productWithout0 = 1;
        for(int i = 0; i< nums.length; i++){
            if(nums[i] == 0){
                count0++;
                index0 = i;
            }
            else{
                productWithout0 *= nums[i];
            }
        }
        if(count0 == 0){
            for(int i = 0; i< nums.length; i++){
                output[i] = productWithout0 / nums[i];
            }
            return output;
        }
        else if(count0 == 1){
            output[index0] = productWithout0;
            return output;
        }
        else{
            return output;
        }
    }
}
