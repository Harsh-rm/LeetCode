class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] result = new int[] {-1, -1};
        int firstPos, lastPos;

        if (nums == null || nums.length == 0) return result;
        
        if (target < nums[0] || target > nums[n - 1]) return result;

        firstPos = binarySearchFirst(nums, 0, n - 1, target);

        if (firstPos == -1) {
            return result;
        }

        lastPos = binarySearchLast(nums, firstPos, n - 1, target);
        
        result[0] = firstPos;
        result[1] = lastPos;

        return result;
    }

    public int binarySearchFirst(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2; //prevent integer overflow

            if (nums[mid] == target) {
                if (mid == low || nums[mid - 1] < nums[mid]) {
                    return mid;
                }
                high = mid - 1;

            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    public int binarySearchLast(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2; //prevent integer overflow

            if (nums[mid] == target) {
                if (mid == high || nums[mid + 1] > nums[mid]) {
                    return mid;
                }
                low = mid + 1;

            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}