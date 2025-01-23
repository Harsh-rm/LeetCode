class Solution {
    int count, m, n;
    int[][] dirs;
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        m = grid.length;
        n = grid[0].length;
        dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int row, int col) {
        //Base case
        if (row < 0 || col < 0 || row == m || col == n || grid[row][col] != '1') return;
        //logic
        grid[row][col] = '0';
        for(int[] dir: dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            dfs(grid, newRow, newCol);
        }
    }
}