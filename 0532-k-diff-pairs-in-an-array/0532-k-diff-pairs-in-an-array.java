class Solution {
    public int findPairs(int[] nums, int k) {
        int count = 0;

        if (nums == null || nums.length == 1) return count;

        HashMap<Integer, Integer> freqMap = new HashMap<>();

        IntStream.range(0, nums.length).forEach(i -> {
            freqMap.put(nums[i], freqMap.getOrDefault(nums[i], 0) + 1);
        });

        for (int key: freqMap.keySet()) {
            if (k == 0 && freqMap.get(key) > 1) {
                count++;
            }
            else if (k != 0 && freqMap.containsKey(key + k)) {
                count++;
            }
        }

        return count;
    }
}