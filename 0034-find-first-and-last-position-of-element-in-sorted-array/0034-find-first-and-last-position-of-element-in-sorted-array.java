class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[] {-1,-1};
        if(target < nums[0] || target > nums[nums.length - 1]) return new int[] {-1,-1};

        int firstocc = BinarySearchFirst(nums, target);
        if(firstocc == -1) {
          return new int[] {-1,-1};
        }

        int lastocc = BinarySearchLast(nums, target, firstocc);
        return new int[] {firstocc, lastocc};
    }

    private int BinarySearchFirst(int[] nums, int target) {
      int low = 0;
      int n = nums.length;
      int high = n - 1;
      
      while(low <= high) {
        int mid = low + (high - low) / 2;
        if(target == nums[mid]) {
          if(mid == low || nums[mid - 1] < nums[mid]) { //If first expression is true the second expression is not evaluated
            return mid;
          }
          high = mid - 1;
        }
        else if(target > nums[mid]) {
          low = mid + 1;
        }
        else {
          high = mid - 1;
        }
      }
      return -1;
    }

    private int BinarySearchLast(int[] nums, int target, int firstocc) {
      int low = firstocc;
      int n = nums.length;
      int high = n - 1;
      
      while(low <= high) {
        int mid = low + (high - low) / 2;
        if(target == nums[mid]) {
          if(mid == high || nums[mid] < nums[mid + 1]) {
            return mid;
          }
          low = mid + 1;
        }
        else if(target > nums[mid]) {
          low = mid + 1;
        }
        else {
          high = mid - 1;
        }
      }
      return -1;
    }
}