class Solution {
    public int[] searchRange(int[] nums, int target) {
        /*int[] range = {-1,-1};
         int index = bsearch(nums, target, 0, nums.length-1);
         //System.out.println(index);
         if(index == -1)
         return range;
         for(int i = index; i>=0; i--)
         if(nums[i] == target)
         range[0] = i;
         for(int i = index; i<nums.length; i++)
         if(nums[i] == target)
         range[1] = i;
         return range;
         }
         private int bsearch(int[] nums, int target, int l, int r){
         if(l>r)
         return -1;
         int mid = (l+r)/2;
         if(nums[mid] == target)
         return mid;
         else{
         if(nums[mid] > target)
         return bsearch(nums, target, l, mid-1);
         else
         return bsearch(nums, target, mid+1, r);
         }
         */
        int[] ans = {-1,-1};
        if(nums.length == 0)
            return ans;
        int l = 0;
        int r = nums.length-1;
        while(l<r){
            int mid = (l+r)/2;
            if(nums[mid] < target)
                l = mid + 1;
            else
                r = mid;
        }
        
        if(nums[l]!=target)
            return ans;
        ans[0] = l;
        l = 0;
        r = nums.length-1;
        while(l<r){
            int mid = (l+r)/2;
            if(nums[mid] <= target)
                l = mid + 1;
            else
                r = mid;
        }
        if(nums[l] > target)
            ans[1] = l-1;
        else
            ans[1] = l;
        return ans;
    }
}
