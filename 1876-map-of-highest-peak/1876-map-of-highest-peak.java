class Solution {
    private int m, n;
    private int[][] dirs;
    private int[][] height;
    
    public int[][] highestPeak(int[][] isWater) {
        if (isWater == null || isWater.length == 0) return new int[0][0];

        m = isWater.length;
        n = isWater[0].length;
        dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; //Right, Down, Left, Up

        height = new int[m][n];

        Queue<int[]> bfs = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    bfs.add(new int[] {i, j});
                }
                else {
                    height[i][j] = -1;
                }
            }
        }

        AtomicInteger distance = new AtomicInteger(0);

        while (!bfs.isEmpty()) {
            int[] curr = bfs.poll();

            Arrays.stream(dirs)
                    .map(dir -> new int[] {curr[0] + dir[0], curr[1] + dir[1]})
                    .filter(isValidPosition())
                    .filter(pos -> isNotVisited().test(pos, height))
                    .forEach(pos -> {
                        bfs.add(pos);
                        height[pos[0]][pos[1]] = height[curr[0]][curr[1]] + 1;
                    });
        }

        return height;
    }

    private Predicate<int[]> isValidPosition() {
        return pos -> pos[0] >= 0 && pos[0] < m && pos[1] >= 0 && pos[1] < n;
    }

    private BiPredicate<int[], int[][]> isNotVisited() {
        return (pos, height) -> height[pos[0]][pos[1]] == -1;
    }
}