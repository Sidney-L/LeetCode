class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> l = new LinkedList();
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums1.length; i++){
            set.add(nums1[i]);
        }
        for(int i = 0; i < nums2.length; i++){
            if(set.contains(nums2[i])){
                set.remove(nums2[i]);
                l.add(nums2[i]);
            }
        }
        int[] ans = new int[l.size()];
        for(int i = 0; i < l.size(); i++)
            ans[i] = l.get(i);
        return ans;
    }
}
