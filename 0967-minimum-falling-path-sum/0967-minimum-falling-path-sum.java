class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;

        int n = matrix.length;

        for(int i = n - 2; i >= 0; i--) {
            for(int j = 0; j <= n - 1; j++) {
                if(j == 0) {
                    matrix[i][j] += Math.min(matrix[i + 1][j], matrix[i + 1][j + 1]);
                }
                else if(j == n - 1) {
                    matrix[i][j] += Math.min(matrix[i + 1][j - 1], matrix[i + 1][j]);
                }
                else {
                    matrix[i][j] += Math.min(Math.min(matrix[i + 1][j - 1], matrix[i + 1][j]), matrix[i + 1][j + 1]);
                }
            }
        }

        int temp = IntStream.range(0, n)
                            .map(i -> matrix[0][i])
                            .min()
                            .orElse(Integer.MAX_VALUE);

        return temp;
    }
}