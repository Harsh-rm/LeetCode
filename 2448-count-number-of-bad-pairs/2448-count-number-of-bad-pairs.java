class Solution {
    private long result;
    
    public long countBadPairs(int[] nums) {
        result = 0;

        if (nums == null || nums.length == 1) return result;

        HashMap<Integer, Long> uniquePairs = new HashMap<>();

        //Calculate the total pairs n * (n - 1) / 2
        result = (long) nums.length * (nums.length - 1) / 2;

        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i] - i;

            result -= uniquePairs.getOrDefault(currNum, 0L);

            uniquePairs.put(currNum, uniquePairs.getOrDefault(currNum, 0L) + 1);
        }

        return result;
    }
}