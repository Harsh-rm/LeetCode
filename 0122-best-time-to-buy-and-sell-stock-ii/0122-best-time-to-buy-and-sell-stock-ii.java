class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        
        int n = prices.length;
        int prev = prices[0];
        int curr, total = 0;
        
        for (int i = 1; i < n; i++) {
            curr = prices[i];
            if (prev < curr) {
                total += curr - prev;
            }
            prev = curr;
        }
        return total;
    }
}