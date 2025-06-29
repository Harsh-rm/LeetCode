class Solution {

    private static final int[][] dirs = new int[][] {{0,1}, {1,0}};
    private int result = Integer.MIN_VALUE;
    private int m, n;

    public int minPathSum(int[][] grid) {
        
        try {
            if (grid == null || grid.length == 0) return result;

            this.m = grid.length;
            this.n = grid[0].length;

            result = helper(grid);
        }
        catch (RuntimeException e) {
            System.err.println("Exception in minPathSum(int[][] grid) -> class Solution: " + e.getMessage());
            throw e;
        }

        return result;
    }

    private int helper(int[][] grid) {
        
        for (int i = this.m - 1; i >= 0; i--) {

            for (int j = this.n - 1; j >= 0; j--) {

                if (i == this.m - 1 && j != this.n - 1) {
                    grid[i][j] = grid[i][j] + grid[i][j + 1];
                }
                else if (i != this.m - 1 && j == this.n - 1) {
                    grid[i][j] = grid[i][j] + grid[i + 1][j];
                }
                else if (i != this.m - 1 && j != this.n - 1) {
                    grid[i][j] = grid[i][j] + Math.min(grid[i][j + 1], grid[i + 1][j]);
                }
                else {
                    //do nothing
                }
            }
        }

        return grid[0][0];
    }
}