class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) return false;

        int n = matrix.length;
        int m = matrix[0].length;
        boolean result = false;

        for (int i = 0; i < n; i++) {
            result = binarySearch(matrix[i], 0, m - 1, target);
            if (result) {
                break;
            }
        }

        return result;
    }

    private boolean binarySearch(int[] row, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (row[mid] == target) {
                return true;
            } else if (row[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}