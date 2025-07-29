class Solution {

    private int[] nums;
    private int k;
    private int count;
    private List<List<Integer>> result;
    private Map<Integer, Integer> freqMap;

    public int subarraysWithKDistinct(int[] nums, int k) {
        this.count = 0;

        if (nums == null || nums.length == 0 || k == 0) return count;

        try {
            this.nums = nums;
            this.k = k;
            this.result = new ArrayList<>();
            this.freqMap = new HashMap<>();

            int leftFar = 0, leftNear = 0, right = 0;

            while (right < nums.length) {

                freqMap.put(nums[right], freqMap.getOrDefault(nums[right], 0) + 1);
                
                while (freqMap.size() > k) {
                    freqMap.compute(nums[leftNear], (key, v) -> (v == null || v - 1 == 0) ? null : v - 1);
                    leftNear++;
                    leftFar = leftNear;
                }

                while (freqMap.get(nums[leftNear]) > 1) {
                    freqMap.put(nums[leftNear], freqMap.get(nums[leftNear]) - 1);
                    leftNear++;
                }

                if (freqMap.size() == k) {
                    count += (leftNear - leftFar) + 1;
                }

                right++;
            }

            return count;
        }
        catch (RuntimeException e) {
            System.err.println("Unchecked exception in subarraysWithKDistinct(int[] , int ) -> class Solution: " + e.getMessage());
            return -1;
        }
    }
}