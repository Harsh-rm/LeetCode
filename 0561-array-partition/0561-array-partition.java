class Solution {
    public int arrayPairSum(int[] nums) {
        int sum = 0;
        int n = nums.length;

        if (nums == null || n == 0) return sum;
               
        Arrays.sort(nums);

        for (int i = n - 2; i >= 0; i = i - 2) {
            sum += nums[i];
        }

        return sum;
    }
}