class Solution {

    private int result;
    private int m, n;

    public int countBattleships(char[][] board) {
        this.result = 0;

        if (board == null || board.length == 0) return result;

        this.m = board.length;
        this.n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X' &&
                    (i == 0 || board[i - 1][j] != 'X') &&
                    (j == 0 || board[i][j - 1] != 'X')) {
                    result++;
                }
            }
        }

        return result;
    }
}