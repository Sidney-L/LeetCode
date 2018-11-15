import java.util.Collection;
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(!map.containsKey(nums[i]))
                map.put(nums[i], 1);
            else
                map.put(nums[i], map.get(nums[i])+1);
        }
        int[] s = new int[nums.length+1];
        Collection<Integer> count = map.values();
        for(Integer i : count){
            s[i]++;
        }
        int b = nums.length;
        int cu = 0;
        while(cu < k){
            cu += s[b--];
        }
        List<Integer> ans = new LinkedList<Integer>();
        Set<Map.Entry<Integer,Integer>> set = map.entrySet();
        for(Map.Entry<Integer,Integer> e: set){
            if(e.getValue() > b)
                ans.add(e.getKey());
        }
        return ans;
    }
}
