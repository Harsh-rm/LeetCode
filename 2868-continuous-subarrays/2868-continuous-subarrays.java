class Solution {

    private long result;
    private TreeMap<Integer, Integer> freqMap;

    public long continuousSubarrays(int[] nums) {
        this.result = 0;

        if (nums == null || nums.length == 0) return result;

        if (nums.length == 1) return 1;

        int n = nums.length;
        this.freqMap = new TreeMap<>();
        int left = 0, right = 0;

        while (right < n) {
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);

            while (freqMap.lastEntry().getKey() - freqMap.firstEntry().getKey() > 2) {
                freqMap.compute(nums[left], (key, value) -> (value == null || value - 1 == 0) ? null : value - 1);
                left++;
            }

            result += right - left + 1;
            
            right++;
        }

        return result;
    }
}