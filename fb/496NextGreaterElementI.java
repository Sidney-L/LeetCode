class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i<nums2.length; i++){//record the elements index
            map.put(nums2[i], i);
        }
        int[] ans = new int[nums1.length];
        for(int j = 0; j < nums1.length; j++){
            boolean flag =  false;
            for(int k = map.get(nums1[j]) + 1; k < nums2.length; k++){
                if(nums2[k] > nums1[j]){
                    ans[j] = nums2[k];
                    flag = true;
                    break;
                }
            }
            if(!flag){
                ans[j] = -1;
            }
        }
        return ans;
    }
}
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
Stack<Integer> st = new Stack<Integer>();
int nextGreater[] = new int[nums2.length];
for(int i = 0; i<nums2.length; i++){//record the elements index
map.put(nums2[i], i);
while(!st.isEmpty()&& nums2[i] > nums2[st.peek()]){
nextGreater[st.pop()] = nums2[i];
}
st.push(i);
}
while(!st.isEmpty()){
nextGreater[st.pop()] = -1;
}
int[] ans = new int[nums1.length];
for(int j = 0; j < nums1.length; j++){
ans[j] = nextGreater[map.get(nums1[j])];
}
return ans;
    }
}
