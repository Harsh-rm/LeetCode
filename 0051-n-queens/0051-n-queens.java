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
        for (int i = 0; i < n; i++) {
            //Action
            String tempRow = path.get(index);

            if (isNotSafeCol.contains(i) || isNotSafeDiagonal(index, i, path)) {
                continue;
            }

            String newRow = tempRow.substring(0, i) + 'Q' + tempRow.substring(i + 1);
            path.set(index, newRow);
            isNotSafeCol.add(i);

            //Recurse
            helper(index + 1, path);

            //Backtrack
            path.set(index, tempRow);
            isNotSafeCol.remove(i);
        }
    }

    private boolean isNotSafeDiagonal(int row, int col, List<String> path) {
        boolean flag = false;

        //Left Diagonal
        int newRow = row - 1, newCol = col - 1;
        while (newRow >= 0 && newCol >= 0) {
            String tempRow = path.get(newRow);
            if (tempRow.charAt(newCol) == 'Q') {
                flag = true;
                return flag;
            }
            newRow--; newCol--;
        }

        //Right Diagonal
        newRow = row - 1;
        newCol = col + 1;
        while (newRow >= 0 && newCol < n) {
            String tempRow = path.get(newRow);
            if (tempRow.charAt(newCol) == 'Q') {
                flag = true;
                return flag;
            }
            newRow--; newCol++;
        }

        return flag;
    }
}