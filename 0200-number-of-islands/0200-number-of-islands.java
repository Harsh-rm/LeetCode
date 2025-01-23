class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[] {i, j});
                    grid[i][j] = '0';
                    //Perform BFS to find the island across the m x n matrix and mark them as '0' or '2'
                    while(!q.isEmpty()) {
                        int[] curr = q.poll();

                        for (int[] dir: dirs) {
                            int newRow = curr[0] + dir[0];
                            int newCol = curr[1] + dir[1];
                            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == '1') {
                                grid[newRow][newCol] = '0';
                                q.add(new int[] {newRow, newCol});
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}