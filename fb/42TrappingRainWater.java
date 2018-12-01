class Solution {
    public int trap(int[] height) {
        if(height.length == 0)
            return 0;
        int[] leftMax = new int[height.length];
        for(int i = 0; i < height.length; i++){
            if(i==0)
                leftMax[i]=height[i];
            else{
                leftMax[i]=Math.max(leftMax[i-1], height[i]);
            }
        }
        int[] rightMax = new int[height.length];
        for(int i = height.length-1; i >= 0; i--){
            if(i==height.length-1)
                rightMax[i]=height[height.length-1];
            else{
                rightMax[i]=Math.max(rightMax[i+1], height[i]);
            }
        }
        int count = 0;
        for(int i = 0; i < height.length; i++){
            count+= Math.max(Math.min(leftMax[i], rightMax[i]) - height[i], 0);
        }
        return count;
    }
}
