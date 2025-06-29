class Solution {

    private int result;
    private int n;
    private int[][] matrix;

    public int kthSmallest(int[][] matrix, int k) {
        this.result = Integer.MIN_VALUE;

        if (matrix == null || matrix.length == 0) return this.result;

        this.matrix = matrix;
        this.n = matrix.length;        

        int start = matrix[0][0];
        int end = matrix[n - 1][n - 1];

        while (start < end) {
            int mid = start + (end - start) / 2;

            int[] smallLargePair = new int[] {matrix[0][0], matrix[n - 1][n - 1]};

            int count = this.countElementsToLeft(mid, smallLargePair);

            if (count < k) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }

        return start;
    }

    private int countElementsToLeft(int mid, int[] smallLargePair) {
        int row = n - 1, col = 0;
        int count = 0;

        while (row >= 0 && col < n) {
            if (mid < this.matrix[row][col]) {
                smallLargePair[1] = Math.min(smallLargePair[1], this.matrix[row][col]);
                row--;
            } else {
                smallLargePair[0] = Math.max(smallLargePair[0], this.matrix[row][col]);
                col++;
                count += row + 1;
            }
        }
        
        return count;
    }
}