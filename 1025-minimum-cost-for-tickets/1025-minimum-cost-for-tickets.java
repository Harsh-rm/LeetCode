class Solution {
    private int[] dp;
    private Set<Integer> set;

    public int mincostTickets(int[] days, int[] costs) {
        if (days == null || days.length == 0) return 0;

        int n = days.length;
        dp = new int[days[n - 1] + 1];

        set = Arrays.stream(days).boxed().collect(Collectors.toSet());

        for (int i = 1; i < dp.length; i++) {
            if (set.contains(i)) {
                int case1 = dp[i - 1] + costs[0];
                int case7 = dp[Math.max(0, i - 7)] + costs[1];
                int case30 = dp[Math.max(0, i - 30)] + costs[2];

                dp[i] = Math.min(case1, Math.min(case7, case30));
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[dp.length - 1];
    }
}