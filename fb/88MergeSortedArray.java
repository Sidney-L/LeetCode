class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int cur2 = 0;
        int last = m - 1;
        int count = 0;
        for(int cur1 = 0; cur1 < m + n; cur1++){
            if(cur2 == nums2.length)
                return;
            if(count != m){
                if(nums1[cur1] <= nums2[cur2])
                {count++;}
                
                else{
                    for(int i = last + 1; i > cur1; i--){
                        nums1[i] = nums1[i-1];
                    }
                    nums1[cur1] = nums2[cur2];
                    cur2++;
                    last++;
                }
            }
            else{
                nums1[cur1] = nums2[cur2];
                cur2++;
            }
        }
    }
}
