class Solution {
    public int maxProfit(int[] prices) {
        int l=0, r=prices.length-1;
        int profit = 0;
        int buy = Integer.MAX_VALUE;
        while(l<=r){
            if(prices[l]<buy){
                buy=prices[l];
            }
            profit = Math.max(profit,prices[l]-buy);
            l++;
        }
        return profit;
    }
}
