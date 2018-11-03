class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }
        List<Integer> l = new LinkedList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums1.length; i++){
            if(map.containsKey(nums1[i]))
                map.put(nums1[i], map.get(nums1[i])+1);
            else
                map.put(nums1[i], 1);
        }
        for(int i = 0; i < nums2.length; i++){
            if(map.containsKey(nums2[i])){
                l.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i])-1);
                if(map.get(nums2[i]) == 0)
                    map.remove(nums2[i]);
            }
        }
        int[] ans = new int[l.size()];
        for(int i = 0; i < l.size(); i++)
            ans[i] = l.get(i);
        return ans;
    }
}
