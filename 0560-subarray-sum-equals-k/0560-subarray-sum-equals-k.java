class Solution {

    private Integer n, rSum, result;
    private Map<Integer, Integer> freqMap;

    public int subarraySum(int[] nums, int k) {
        this.result = 0;
        if (nums == null || nums.length == 0) return result;

        this.n = nums.length;
        this.rSum = 0;
        this.freqMap = new HashMap<>();

        freqMap.put(0, 1);

        for(int i = 0; i < n; i++) {
            rSum += nums[i];

            if (freqMap.containsKey(rSum - k)) {
                result += freqMap.get(rSum - k);
            }

            freqMap.put(rSum, freqMap.getOrDefault(rSum, 0) + 1);
        }

        return result;
    }
}