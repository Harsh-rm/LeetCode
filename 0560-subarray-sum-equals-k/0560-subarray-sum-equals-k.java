class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;

        int count = 0;
        ArrayList<int[]> result = new ArrayList<>();

        int rSum = 0;
        HashMap<Integer, ArrayList<Integer>> rSumMap = new HashMap<>();

        rSumMap.put(rSum, new ArrayList<>());
        rSumMap.get(rSum).add(-1);

        for (int i = 0; i < nums.length; i++) {
            rSum += nums[i];

            // Check if there exists a runningSum such that runningSum - k exists in the map
            int diff = rSum - k;
            if (rSumMap.containsKey(diff)) {
                for (int startIdx : rSumMap.get(diff)) {
                    //result.add(Arrays.copyOfRange(nums, startIdx + 1, i + 1));
                    count++;
                }
            }

            // Add the current running sum to the map
            rSumMap.putIfAbsent(rSum, new ArrayList<>());
            rSumMap.get(rSum).add(i);
        }

        return count;
    }
}