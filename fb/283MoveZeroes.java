class Solution {
    public void moveZeroes(int[] nums) {
        /*int last = nums.length-1;
         for(int i = 0; i <= last; ){
         if(nums[i] == 0){
         for(int j = i; j < last; j++){
         nums[j] = nums[j+1];
         }
         nums[last] = 0;
         last--;
         }
         else{
         i++;
         }
         }
         */
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0)
                nums[index++] = nums[i];
        }
        for(;index < nums.length; index++){
            nums[index] = 0;
        }
    }
}
