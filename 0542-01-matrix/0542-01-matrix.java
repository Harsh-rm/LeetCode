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

        AtomicInteger distance = new AtomicInteger();

        while (!visited.isEmpty()) {            
            int size = visited.size();
            distance.getAndIncrement();

            IntStream.range(0, size).forEach(i -> {
                int[] curr = visited.poll();

                Arrays.stream(dirs)
                        .map(dir -> new int[]{curr[0] + dir[0], curr[1] + dir[1]})
                        .filter(isValidPosition())
                        .filter(pos -> isNotVisited().test(pos, mat))
                        .forEach(pos -> {
                            visited.add(pos);
                            mat[pos[0]][pos[1]] = distance.get();
                        });
            });
        }
    }

    private Predicate<int[]> isValidPosition() {
        return pos -> pos[0] >= 0 && pos[0] < m && pos[1] >= 0 && pos[1] < n;
    }

    private BiPredicate<int[], int[][]> isNotVisited() {
        return (pos, mat) -> mat[pos[0]][pos[1]] == -1;
    }
}