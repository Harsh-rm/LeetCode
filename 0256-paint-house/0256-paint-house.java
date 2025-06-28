class Solution {

    private int result;
    private int length;

    public int minCost(int[][] costs) {
        
        try {
            this.result = 0;

            if (costs == null || costs.length == 0) return result;

            this.length = costs.length;

            IntStream.range(1, length).forEach(i -> {
                IntStream.range(0, 3).forEach(j -> {
                    if (j == 0) {
                        costs[i][j] += Math.min(costs[i - 1][j + 1], costs[i - 1][j + 2]);
                    } else if (j == 1) {
                        costs[i][j] += Math.min(costs[i - 1][j - 1], costs[i - 1][j + 1]);
                    } else {
                        costs[i][j] += Math.min(costs[i - 1][j - 1], costs[i - 1][j - 2]);
                    }
                });
            });

            this.result = IntStream.range(0, 3)
                                .map(i -> costs[length - 1][i])
                                .min()
                                .orElse(0);
        
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }
}