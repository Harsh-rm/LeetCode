class Solution {
    private String word;
    private char[][] board;
    private int[][] dirs;
    private int m, n;
    private boolean result;
    
    public boolean exist(char[][] board, String word) {
        result = false;

        if (board == null || board.length == 0) return result;

        this.word = word;
        this.board = board;
        this.dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        this.m = board.length;
        this.n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {                    
                    dfs(1, i, j);
                }
                if (this.result) break;
            }
        }

        return this.result;
    }

    private void dfs(int index, int row, int col) {
        //Base case
        if (index == word.length()) {
            this.result = true;
            return;
        }
        //Logic
        //Action
        char temp = board[row][col];
        board[row][col] = '\u0000';

        //Recurse
        for (int[] dir: dirs) {
            int nr = row + dir[0];
            int nc = col + dir[1];

            if (nr >= 0 && nr < m && nc >= 0 && nc < n && board[nr][nc] == word.charAt(index)) {

                dfs(index + 1, nr, nc);

            }

            if (this.result) break;
        }

        board[row][col] = temp;
    }
}