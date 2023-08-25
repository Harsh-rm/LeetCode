class Solution {
    public int[] twoSum(int[] nums, int target) {
        if(nums == null || nums.length < 2) return new int[] {};

        int n = nums.length;
        Map<Integer, Integer> numsMap = new HashMap<>();
        int[] result;

        for(int i = 0; i < n; i++) {
            numsMap.put(nums[i], i);
        }

        for(int i = 0; i < n; i++) {
            if (numsMap.containsKey(target - nums[i]) && numsMap.get(target - nums[i]) != i) {
                return new int[] {i, numsMap.get(target - nums[i])};
            }
        }

        return new int[] {};
    }
}