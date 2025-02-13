package LeetCode.0001-Knapsack-problem;


class Solution {
    // Function to return max value that can be put in knapsack of capacity.
    static int[][] memo;
    
    static int knapSack(int capacity, int val[], int wt[]) {
        // code here
        if (wt.length == 0 || capacity == 0) return 0;
        
        int n = wt.length;
        
        memo = new int[n][capacity + 1];
        
        for (int[] row: memo) {
            for (int i = 0; i < row.length; i++) {
                row[i] = -1;
            }
        }
        
        return helper(capacity, val, wt, 0);
    }
    
    static private int helper(int capacity, int[] val, int[] wt, int n) {
        if (n == wt.length || capacity == 0) return 0;
        
        if (wt[n] > capacity) {
            memo[n][capacity] = helper(capacity, val, wt, n + 1);
        } else {
            memo[n][capacity] = Math.max(helper(capacity, val, wt, n + 1), val[n] + helper(capacity - wt[n], val, wt, n + 1));
        }
   
        return memo[n][capacity];
    }
}