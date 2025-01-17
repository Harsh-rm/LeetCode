class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null) return 0;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right];
                right--;
            } else {
                left++;
            }
        }

        return left;
    }
}