
class Solution {
    /*
     public void rotate(int[] nums, int k) {
     int n = nums.length;
     if(n==0)
     return;
     k = k % n;
     int[] temp = new int[k];
     int index = 0;
     for(int i = n-k; i < n; i++){
     temp[index++] = nums[i];
     }
     for(int i = n-k-1; i>=0; i--){
     nums[i+k] = nums[i];
     }
     index = 0;
     for(int i: temp)
     nums[index++] = i;
     }
     */
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        int visit = 0;
        for(int index = 0; visit < nums.length; index++){
            int cur = index;
            int prev = nums[index];
            do{
                int next = (cur + k)%nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                cur = next;
                visit++;
            }while(index!=cur);
        }
    }
}
