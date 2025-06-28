class Solution {

    private int result;
    private int length;

    public int minCost(int[][] costs) {
        
        try {
            this.result = 0;

            if (costs == null || costs.length == 0) return result;

            this.length = costs.length;

            int[] prev = costs[0];

            for (int i = 1; i < length; i++) {
                int[] current = new int[3];
                final int row = i;
                final int[] previous = prev;

                IntStream.range(0, 3).forEach(j -> {
                    final int color = j;
                    current[color] = costs[row][color] +
                                    IntStream.range(0, 3)
                                            .filter(k -> k != color)
                                            .map(k -> previous[k])
                                            .min()
                                            .orElse(0);
                });

                prev = current;
            }

            result = IntStream.of(prev).min().orElse(0);
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }
}