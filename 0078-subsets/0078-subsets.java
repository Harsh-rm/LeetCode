class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();

        if (nums == null || nums.length == 0) return result;
        
        helper(nums, 0, new ArrayList<>());

        return result;
    }

    private void helper(int[] nums, int index, List<Integer> path) {
        //base
        result.add(path);
        //logic
        for(int i = index; i < nums.length; i++) {
            List<Integer> newlist = new ArrayList<>(path);

            newlist.add(nums[i]);

            helper(nums, i + 1, newlist);
        }
    }
}