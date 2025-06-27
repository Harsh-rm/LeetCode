class Solution {

    private int[][] matrix;
    private int n;

    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0) return Integer.MAX_VALUE;

        this.matrix = matrix;
        this.n = matrix.length;

        int start = matrix[0][0];
        int end = matrix[n - 1][n - 1];

        if (k == 1) return start;
        if (k == Math.pow(n, 2)) return end;
        if (k > Math.pow(n, 2)) return Integer.MAX_VALUE;        

        while (start < end) {
            int mid = end + (start - end) + 1;

            int[] smallLargePair = new int[] {this.matrix[0][0], this.matrix[n - 1][n - 1]};

            int count = this.countElementsToLeft(mid, smallLargePair);

            if (count == k) {
                return smallLargePair[0];
            } else if (count < k) {
                start = smallLargePair[1];
            } else {
                end = smallLargePair[0];
            }
        }

        return start;
    }

    private int countElementsToLeft(int mid, int[] smallLargePair) {
        int count = 0;
        int row = n - 1, col = 0;        

        while (row >= 0 && col < n) {
            if (mid > this.matrix[row][col]) {
                smallLargePair[0] = Math.max(this.matrix[row][col], smallLargePair[0]);
                col++;
                count += row + 1;
            } else {
                smallLargePair[1] = Math.min(this.matrix[row][col], smallLargePair[1]);
                row--;
            }
        }

        return count;
    }
}