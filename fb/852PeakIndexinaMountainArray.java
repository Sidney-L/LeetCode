class Solution {
    public int peakIndexInMountainArray(int[] A) {
        return bsearch(A, 0, A.length-1);
    }
    private int bsearch(int[] nums, int l, int r){
        if(r==l)
            return l;
        else{
            int mid = (l+r)/2;
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1])
                return mid;
            else if(nums[mid]<=nums[mid-1]){
                return bsearch(nums, l, mid-1);
            }
            else
                return bsearch(nums,mid+1, r);
        }
    }
}
