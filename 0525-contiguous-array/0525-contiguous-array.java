class Solution {
    public int findMaxLength(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxLength = 0;
        int n = nums.length;
        int rSum = 0;
        HashMap<Integer, Integer> rSumtoIndexMap = new HashMap<>();
        
        rSumtoIndexMap.put(rSum, -1);

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                rSum += -1;
            } else {
                rSum += 1;
            }

            if (!rSumtoIndexMap.containsKey(rSum)) {
                rSumtoIndexMap.put(rSum, i);
            } else {
                maxLength = Math.max(maxLength, i - rSumtoIndexMap.get(rSum));
            }
        }

        return maxLength;
    }
}