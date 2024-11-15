class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) return;

        int n = nums.length;
        int index = -1;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        if (index != -1) {
            for (int i = n - 1; i > index; i--) {
                if (nums[index] < nums[i]) {
                    swap(nums, index, i);
                    break;
                }
            }
        }

        reverse(nums, index + 1, n -1);
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    private void reverse(int[] nums, int l, int r) {
        while (l <= r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }
}