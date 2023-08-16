class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[] {-1, -1};
        if (target < nums[0] || target > nums[nums.length - 1]) return new int[] {-1, -1};

        int firstOcc = binarySearchFirst(nums, target);
        if (firstOcc == -1) {
            return new int[] {-1, -1};
        }

        int lastOcc = binarySearchLast(nums, target, firstOcc);
        return new int[] {firstOcc, lastOcc};
    }

    private int binarySearchFirst(int[] nums, int target) {
        int low = 0;
        int n = nums.length;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                if (mid == low || nums[mid - 1] < target) {
                    return mid;
                }
                high = mid - 1;
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }

    private int binarySearchLast(int[] nums, int target, int firstOcc) {
        int low = firstOcc;
        int n = nums.length;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                if (mid == high || nums[mid + 1] > target) {
                    return mid;
                }
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return firstOcc;
    }
}