class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        int count = 0;
        int rSum = 0;
        HashMap<Integer, Integer> rSumMap = new HashMap<>();

        rSumMap.put(rSum, 1);
 

        for (int i = 0; i < nums.length; i++) {
            rSum += nums[i];

            if (rSumMap.containsKey(rSum - k)) {
                count += rSumMap.get(rSum - k);
            }

            rSumMap.put(rSum, rSumMap.getOrDefault(rSum, 0) + 1);
        }

        return count;
    }
}