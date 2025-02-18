class Solution {
    private int result;
    private int m, n;
    private int[][] dirs;

    public int numIslands(char[][] grid) {
        result = 0;

        if (grid == null || grid.length == 0) return result;

        m = grid.length;
        n = grid[0].length;

        dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // Right, Down, Left, Up

        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    result++;
                }
            }
        }

        return result;
    }

    private void bfs(char[][] grid, int row, int col) {
        Queue<int[]> processIsland = new LinkedList<>();

        processIsland.add(new int[] {row, col});

        while (!processIsland.isEmpty()) {
            int[] vertex = processIsland.poll();

            for (int[] dir: dirs) {
                int nr = dir[0] + vertex[0];
                int nc = dir[1] + vertex[1];

                if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == '1') {
                    processIsland.add(new int[] {nr, nc});
                    grid[nr][nc] = '\u0000';                    
                }
            }
        }
    }
}