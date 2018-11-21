class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = {0, numbers.length-1};
        while(ans[0] < ans[1]){
            if(numbers[ans[0]] + numbers[ans[1]] == target){
                ans[0]++;
                ans[1]++;
                return ans;
            }
            else if(numbers[ans[0]] + numbers[ans[1]] < target)
                ans[0]++;
            else
                ans[1]--;
        }
        return ans;
    }
}
