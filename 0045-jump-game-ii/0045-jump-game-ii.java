class Solution {
    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int n = nums.length;
        int far = 0;
        int end = 0;
        int count = 0;

        for (int i = 0; i < n - 1; i++) {
            far = Math.max(far, i + nums[i]);

            if (i == end) {
                count++;
                end = far;
            }
        }

        return count;
    }
}

//[2,3,1,1,4]
//   | |