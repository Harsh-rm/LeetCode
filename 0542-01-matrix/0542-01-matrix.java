class Solution {
    private int m, n;
    private int[][] dirs;

    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0) return new int[0][0];

        m = mat.length;
        n = mat[0].length;
        dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; //Right, Down, Left, Up

        bfs(mat);

        return mat;
    }

    private void bfs(int[][] mat) {
        Queue<int[]> visited = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    visited.add(new int[] {i, j});
                }
                else {
                    mat[i][j] = -1;
                }
            }
        }

        int distance = 0;

        while (!visited.isEmpty()) {            
            int size = visited.size();
            distance++;

            for (int i = 0; i < size; i++) {
                int[] curr = visited.poll();

                for (int[] dir: dirs) {
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] == -1) {
                        visited.add(new int[] {nr, nc});
                        mat[nr][nc] = distance;
                    }
                }
            }
        }
    }
}