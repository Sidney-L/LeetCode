class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null)
            return 0;
        if(prices.length < 2)
            return 0;
        int profit = 0;
        int lowest = prices[0];
        for(int i = 1; i < prices.length; i++){
            profit = Math.max(profit, prices[i] - lowest);
            lowest = Math.min(lowest, prices[i]);
        }
        return profit;
    }
}
