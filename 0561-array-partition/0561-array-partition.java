class Solution {
    public int arrayPairSum(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        if (nums.length == 2) return Math.min(nums[0], nums[1]);
               
        Arrays.sort(nums);

        for (int i = nums.length - 2; i > 1; i = i - 2) {
            nums[i - 2] = nums[i - 2] + nums[i];
        }

        return nums[0];
    }
}