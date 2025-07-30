class Solution {

    Integer n, index;

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0 || nums.length == 1) return;

        this.n = nums.length;
        this.index = -1;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                findGreaterEle(nums, i);
                index = i;
                break;
            }
        }

        Arrays.sort(nums, index + 1, n);

        return;
    }

    private void findGreaterEle(int[] nums, int k) {
        for (int i = n - 1; i > k; i--) {
            if (nums[i] > nums[k]) {
                int temp = nums[i];
                nums[i] = nums[k];
                nums[k] = temp;
                break;
            }
        }
    }
}