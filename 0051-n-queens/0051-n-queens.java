class Solution {
    private List<List<String>> result;
    private Set<Integer> isNotSafeCol;
    private int n;

    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();

        if (n == 0) return result;

        isNotSafeCol = new HashSet<>();
        this.n = n;
        List<String> path = new ArrayList<>();

        String dots = ".".repeat(n);
        IntStream.range(0, n).forEach(i -> {            
            path.add(dots);
        });

        helper(0, path);

        return result;
    }

    private void helper(int index, List<String> path) {
        //Base case
        if (index == n) {
            result.add(new ArrayList<>(path));
            return;
        }
        //Logic
        IntStream.range(0, n).forEach(i -> {
            //Action
            String tempRow = path.get(index);

            if (isNotSafeCol.contains(i) || isNotSafeDiagonal(index, i, path)) {
                return;
            }

            String newRow = tempRow.substring(0, i) + 'Q' + tempRow.substring(i + 1);
            path.set(index, newRow);
            isNotSafeCol.add(i);

            //Recurse
            helper(index + 1, path);

            //Backtrack
            path.set(index, tempRow);
            isNotSafeCol.remove(i);
        });
    }

    private boolean isNotSafeDiagonal(int row, int col, List<String> path) {
    return IntStream.range(1, row + 1)
        .anyMatch(i -> 
            (col - i >= 0 && path.get(row - i).charAt(col - i) == 'Q') ||  // Left Diagonal
            (col + i < n && path.get(row - i).charAt(col + i) == 'Q') // Right Diagonal
        );
    }
}