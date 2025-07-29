class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return Integer.MIN_VALUE;

        if (nums.length == 1) return nums[0];

        int n = nums.length;
        int rSum = nums[0], max = rSum;
        int start = 0, end = 0;

        for (int i = 1; i < n; i++) {
            if (rSum + nums[i] > nums[i]) {
                rSum += nums[i];
            }
            else {
                rSum = nums[i];
                start = i; end = i;
            }

            if (rSum > max) {
                max = rSum;
                end = i;
            }
        }

        System.out.printf("Start: %d, End: %d", start, end);

        return max;
    }
}