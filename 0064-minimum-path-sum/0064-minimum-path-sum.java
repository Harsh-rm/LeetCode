class Solution {

    private int[][] dirs, dp;

    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0) return -1;

        int m = grid.length;
        int n = grid[0].length;

        dirs = new int[][] {{0, 1}, {1, 0}};        
        dp = new int[m][n];

        dp[0][0] = grid[0][0];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                
                for (int[] dir: dirs){
                    int nr = i + dir[0];
                    int nc = j + dir[1];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n){
                        int temp = dp[i][j] + grid[nr][nc];
                        if (dp[nr][nc] == 0) dp[nr][nc] = temp;
                        else dp[nr][nc] = Math.min(dp[nr][nc], temp);
                    }                    
                }
            }
        }

        return dp[m - 1][n -1];
    }
}