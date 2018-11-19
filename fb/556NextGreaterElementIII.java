class Solution {
    public int nextGreaterElement(int n) {
        int[] overflow = {2,1,4,7,4,8,3,6,4,7};
        ArrayList<Integer> list = new ArrayList<Integer>();
        while(n!=0){
            list.add(n%10);
            n /= 10;
        }
        int[] ans = new int[list.size()];
        for(int i = list.size() - 1; i>=0; i--){
            ans[list.size() - 1 - i]  = list.get(i);
        }
        if(!getNextPermutation(ans))
            return -1;
        else if(ans.length > overflow.length)
            return -1;
        else if(ans.length == overflow.length){
            boolean flag = true;
            for(int i = 0; i < overflow.length; i++){
                if(ans[i] > overflow[i]){
                    flag = false;
                    break;
                }
            }
            if(!flag)
                return -1;
            
        }
        
        int res = 0;
        int weight = 1;
        for(int i = ans.length-1; i >= 0; i--, weight*=10){
            res += weight * ans[i];
        }
        return res;
    }
    private boolean getNextPermutation(int[] nums){
        if(nums.length == 0 || nums.length == 1)
            return false;
        for(int start = nums.length-2; start >= 0; start--){
            if(nums[start] < nums[start+1]){
                for(int end = start+1; end < nums.length; end++){
                    if(nums[end] <= nums[start]){
                        swap(end-1, start,nums);
                        reverse(start+1, nums.length-1,nums);
                        return true;
                    }
                }
                swap(start, nums.length-1,nums);
                reverse(start+1, nums.length-1,nums);
                return true;
            }
            else
                continue;
        }
        return false;
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
