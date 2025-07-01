class StepState {
    /**
     * data object to keep the state info for each step:
     * <steps, row, col, remaining_eliminations>
     */
    public int steps, row, col, k;

    public StepState(int steps, int row, int col, int k) {
        this.steps = steps;
        this.row = row;
        this.col = col;
        this.k = k;
    }

    @Override
    public int hashCode() {
        // needed when we put objects into any container class
        return (this.row + 1) * (this.col + 1) * this.k;
    }

    @Override
    public boolean equals(Object other) {
        /**
         * only (row, col, k) matters as the state info
         */
        if (!(other instanceof StepState)) {
            return false;
        }
        StepState newState = (StepState) other;
        return (this.row == newState.row) && (this.col == newState.col) && (this.k == newState.k);
    }

    @Override
    public String toString() {
        return String.format("%d %d %d", this.row, this.col, this.k);
    }
}

class Solution {

    private static final int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; //Right, Down, Left, Up;
    private int rows, cols;

    public int shortestPath(int[][] grid, int k) {
        rows = grid.length;
        cols = grid[0].length;
        int[] target = {rows - 1, cols - 1};

        // if we have sufficient quotas to eliminate the obstacles in the worst case,
        // then the shortest distance is the Manhattan distance.
        if (k >= rows + cols - 2) {
            return rows + cols - 2;
        }

        Deque<StepState> queue = new LinkedList<>();
        HashSet<StepState> seen = new HashSet<>();

        // (steps, row, col, remaining quota to eliminate obstacles)
        StepState start = new StepState(0, 0, 0, k);
        queue.addLast(start);
        seen.add(start);

        while (!queue.isEmpty()) {
            StepState curr = queue.pollFirst();

            // we reach the target here
            if (target[0] == curr.row && target[1] == curr.col) {
                return curr.steps;
            }
            
            // explore the four directions in the next step
            Arrays.stream(dirs)
                .map(dir -> new int[] { curr.row + dir[0], curr.col + dir[1] })
                .filter(isInBounds())
                .map(p -> new StepState(curr.steps + 1, p[0], p[1], curr.k - grid[p[0]][p[1]]))
                .filter(s -> s.k >= 0 && !seen.contains(s))
                .forEach(s -> {
                    seen.add(s);
                    queue.addLast(s);
                });

        }

        // did not reach the target
        return -1;
    }

    private Predicate<int[]> isInBounds() {
        return p -> p[0] >= 0 && p[0] < rows && p[1] >= 0 && p[1] < cols;
    }

}