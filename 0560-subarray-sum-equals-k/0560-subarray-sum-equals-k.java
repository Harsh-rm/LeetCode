class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        HashMap<Integer, Integer> rsumfreqMap = new HashMap<>();
        int rSum = 0;
        int count = 0;
        rsumfreqMap.put(rSum, 1);

        for (int i = 0; i < nums.length; i++) {
            rSum += nums[i];

            if (rsumfreqMap.containsKey(rSum - k)) {
                count += rsumfreqMap.get(rSum - k);
            }

            rsumfreqMap.put(rSum, rsumfreqMap.getOrDefault(rSum, 0) + 1);
        }

        return count;
    }
}