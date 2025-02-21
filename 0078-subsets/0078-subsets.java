class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();

        if (nums == null || nums.length == 0) return result;

        helper(nums, 0, new ArrayList<>());

        return result;
    }

    private void helper(int[] nums, int index, List<Integer> path) {
        //Base case
        if (index == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        //Logic
        helper(nums, index + 1, path);

        path.add(nums[index]);
        helper(nums, index + 1, path);

        path.remove(path.size() - 1);
    }
}