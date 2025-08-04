class Solution {

    private int n;
    private long totalSubArrays;

    public int medianOfUniquenessArray(int[] nums) {
        
        if (nums == null || nums.length == 0) return 0;

        this.n = nums.length;
        this.totalSubArrays = (long) n * (n + 1) / 2;

        int left = 1, right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;

            long count = countSubarraysWithAtMostK(nums, mid);

            if (count * 2 >= totalSubArrays) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }

        return left;
    }

    private long countSubarraysWithAtMostK(int[] nums, int k) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        int left = 0;
        long count = 0;

        for (int right = 0; right < nums.length; right++) {
            freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);

            while (freqMap.size() > k) {
                freqMap.compute(nums[left], (key, value) -> (value == null || value - 1 == 0) ? null : value - 1);
                left++;
            }

            count += right - left + 1;
        }

        return count;
    }
}