class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null) return;

        int n = nums.length;
        int index = -1;

        for (int i = n - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                index = i - 1;
                break;
            }
        }

        if (index != -1) {
            for (int i = n - 1; i >= 0; i--) {
                if (nums[index] < nums[i]) {
                    swap(nums, index, i);
                    break;
                }
            }
        }

        Arrays.sort(nums, index + 1, n);
        
    }

    private void swap(int[] nums, int index, int i) {
        int temp = nums[index];
        nums[index] = nums[i];
        nums[i] = temp;
    }
}