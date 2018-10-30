class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        /*
         int sum = 0;
         int[] prefixSum = new int[nums.length];
         if(nums.length <= 1)
         return false;
         if(nums.length == 2){
         if(k==0)
         return nums[0]+nums[1] == 0;
         return (nums[0]+nums[1])%k == 0;
         }
         for(int i = 0; i < nums.length; i++){
         sum += nums[i];
         prefixSum[i] = sum;
         for(int j = 0; j < i-1; j++){
         if(k==0 && sum == 0)
         return true;
         else if(k!=0 && (sum - prefixSum[j]) % k ==0)
         return true;
         else if(k!= 0&&sum % k == 0)
         return true;
         }
         }
         return false;
         */
        
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        if(nums.length <= 1){
            return false;
        }
        if(k == 0){
            for(int i = 0; i < nums.length - 1; i++){
                if(nums[i] + nums[i+1] == 0)
                    return true;
            }
            return false;
        }
        map.put(0,1);
        sum = nums[0] % k;
        if(sum == 0)
            map.put(0,2);
        else
            map.put(sum, 1);
        for(int i = 1; i < nums.length; i++){
            sum = (nums[i] + sum) % k;
            if(map.containsKey(sum)){
                if(nums[i] % k != 0 || map.get(sum) >=2)
                    return true;
                map.put(sum, map.get(sum)+1);
            }
            else
                map.put(sum, 1);
        }
        return false;
        
        
        /*
         int sum = 0;
         HashMap < Integer, Integer > map = new HashMap < > ();
         map.put(0, -1);
         for (int i = 0; i < nums.length; i++) {
         sum += nums[i];
         if (k != 0)
         sum = sum % k;
         if (map.containsKey(sum)) {
         if (i - map.get(sum) > 1)
         return true;
         } else
         map.put(sum, i);
         }
         return false;
         */
    }
}
