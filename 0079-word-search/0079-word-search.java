class Solution {
    int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int m, n;

    public boolean exist(char[][] board, String word) {
        if (word == null) return false;

        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;   
    }

    private boolean dfs(char[][] board, String word, int index, int i, int j) {
        //Base case
        if (index == word.length()) return true;
                    
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] == ' ') return false;

        if (board[i][j] == word.charAt(index)) {
            //Action
            char temp = board[i][j];
            board[i][j] = ' ';

            //Recurse
            for (int[] dir: dirs) {
                int nr = i + dir[0];
                int nc = j + dir[1];
                
                if (dfs(board, word, index + 1, nr, nc)) {
                    return true;
                }
            }

            //Backtrack
            board[i][j] = temp;
        }

        return false;
    }
}