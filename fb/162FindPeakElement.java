class Solution {
    public int findPeakElement(int[] nums) {
        return bsearch(nums, 0, nums.length-1);
    }
    private int bsearch(int[] nums, int l, int r){
        if(l==r)
            return l;
        int mid = (l+r)/2;
        if(nums[mid]>(mid-1>=0?nums[mid-1]:Integer.MIN_VALUE)&&nums[mid]>(mid+1<=nums.length-1?nums[mid+1]:Integer.MIN_VALUE))
            return mid;
        else if(nums[mid]<(mid+1<=nums.length-1?nums[mid+1]:Integer.MIN_VALUE))
            return bsearch(nums, mid+1, r);
        else //if(nums[mid]<nums[mid-1])
            return bsearch(nums, l, mid);
    }
}
