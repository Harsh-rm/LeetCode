class Solution {
    public int findPairs(int[] nums, int k) {
        int count = 0;

        if (nums == null || nums.length == 1) return count;

        HashMap<Integer, Integer> freqMap = new HashMap<>();

        for (int num: nums) {
            freqMap.merge(num, 1, Integer::sum);
        }

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