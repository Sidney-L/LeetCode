class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if(nums.length == 0)
            return 0;
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        int max = 0;
        map.put(0,-1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(map.containsKey(sum-k)){
                max = Math.max(max, i-map.get(sum-k));
            }
            if(!map.containsKey(sum))
                map.put(sum,i);
        }
        return max;
    }
}
