class Solution {

    private int m, n;

    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) return 0;

        this.m = envelopes.length;
        this.n = envelopes[0].length;

        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                }
                else {
                    return a[0] - b[0];
                }
            }
        });

        int[] secondDim = new int[m];
        for (int i = 0; i < m; i++) secondDim[i] = envelopes[i][1];

        return lengthOfLIS(secondDim);
    }

    private int lengthOfLIS(int[] nums) {
        int[] dp = new int[m];
        int len = 0;

        for (int num: nums) {
            int i = Arrays.binarySearch(dp, 0, len, num);
            if (i < 0) {
                i = -(i + 1);
            }
            dp[i] = num;
            
            if (i == len) {
                len++;
            }
        }

        return len;
    }
}