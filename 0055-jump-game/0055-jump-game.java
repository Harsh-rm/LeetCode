class Solution {
    public boolean canJump(int[] nums) {

        if (nums == null || nums.length == 0) return false;

        if (nums.length == 1) return true;

        int n = nums.length - 1;

        for (int i = nums.length - 1; i >=0; i--) {
            if (i + nums[i] >= n) {
                n = i;
            }
        }

        return n == 0;
    }
}