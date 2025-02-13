class Solution {
    int result;
    int[][] dirs;

    public int orangesRotting(int[][] grid) {
        result = -1;

        if (grid == null || grid.length == 0) return -1;

        dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> bfs = new LinkedList<>();
        int freshOranges = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    bfs.add(new int[] {i, j});
                } 
                else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        if (freshOranges == 0) return ++result;

        while (!bfs.isEmpty()) {
            int size = bfs.size();

            for (int i = 0; i < size; i++) {
                int[] curr = bfs.poll();

                for (int[] dir: dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        bfs.add(new int[] {nr, nc});
                        freshOranges--;
                    }
                }
            }

            result++;
        }

        if (freshOranges > 0) return -1;

        return result;
    }
}