class Solution {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        if (nums.length == 1) return nums[0];
        
        int maxResult = nums[0];        
        int rSum = nums[0];
        int start = 0, end = 0;

        for (int i = 1; i < nums.length; i++) {
            if (rSum + nums[i] > nums[i]) {                
                rSum += nums[i];

                if (rSum > maxResult) {
                    end = i;
                    maxResult = rSum;
                }
            } else {
                rSum = nums[i];

                if (rSum > maxResult) {
                    start = i;
                    end = i;
                    maxResult = rSum;
                }
            }            
        }

        System.out.println("Start Index: " + start + " End Index: " + end);
        return maxResult;
    }
}