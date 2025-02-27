class Solution {
    private boolean result;
    public boolean isValidSudoku(char[][] board) {
        result = false;

        if (board == null || board.length == 0) return result;

        Set<String> isValid = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (!isValid.add(c + " row " + i) || !isValid.add(c + " col " + j) || !isValid.add(c + "sub-box row" + i/3 + " col " + j/3)) {
                        return result;
                    }
                }
            }
        }

        //result = true;

        return !result;
    }
}