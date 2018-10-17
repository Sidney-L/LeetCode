class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<2)
            return 0;
        int ans = 0;
        int[] mx = new int[prices.length];
        int lowest = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++){
            if(i!=0)
                mx[i] = mx[i-1];
            if(prices[i] > lowest)
                mx[i] = Math.max(mx[i], prices[i] - lowest);
            lowest = Math.min(prices[i], lowest);
        }
        ans = mx[prices.length-1];
        int highest = Integer.MIN_VALUE;
        for(int j = prices.length - 1; j > 0; j--){
            if(prices[j] < highest)
                ans = Math.max(ans, mx[j] + highest - prices[j]);
            highest = Math.max(prices[j], highest);
        }
        return ans;
    }
}
