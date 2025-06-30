class Solution {
    private int m, n;
    private static final int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; //Right, Down, Left, Up;

    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0) return new int[0][0];

        this.m = mat.length;
        this.n = mat[0].length;        

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

        while (!visited.isEmpty()) {            

            final int[] curr = visited.poll();

            Arrays.stream(dirs)
                    .map(dir -> new int[] {curr[0] + dir[0], curr[1] + dir[1]})
                    .filter(isValidPosition())
                    .filter(pos -> isNotVisited().test(pos, mat))
                    .forEach(pos -> {
                        visited.add(pos);
                        mat[pos[0]][pos[1]] = mat[curr[0]][curr[1]] + 1;
                    });
        }
    }

    private Predicate<int[]> isValidPosition() {
        return pos -> (pos[0] >= 0 && pos[0] < m && pos[1] >=0 && pos[1] < n);
    }

    private BiPredicate<int[], int[][]> isNotVisited() {
        return (pos, mat) -> (mat[pos[0]][pos[1]] == -1);
    }
}