class Solution {
    public int search(int[] nums, int target) {
        return searchIndex(nums, 0, nums.length-1, target);
    }
    
    private int searchIndex(int[] nums, int l, int r, int target){
        if(l > r){
            return -1;
        }
        int mid = (l+r)/2;
        if(nums[mid] == target)
            return mid;
        else{
            if(nums[mid] > nums[r]){
                if(nums[mid] > target){
                    if(target < nums[l])
                        return searchIndex(nums, mid+1, r, target);
                    else
                        return searchIndex(nums, l, mid-1, target);
                }
                else{
                    return searchIndex(nums, mid+1, r, target);
                }
            }
            else{
                if(nums[mid] > target)
                    return searchIndex(nums, l, mid-1, target);
                else {
                    if(target > nums[r])
                        return searchIndex(nums, l, mid-1, target);
                    else
                        return searchIndex(nums, mid+1, r, target);
                }
            }
        }
    }
}
