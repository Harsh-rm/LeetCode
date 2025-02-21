class Solution {
    List<List<Integer>> result;
    
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();

        if (nums == null || nums.length == 0) return result;

        List<Integer> emptyList = new ArrayList<>();

        helper(nums, 0, emptyList);

        return result;
    }

    private void helper(int[] nums, int index, List<Integer> path) {
        //Base case
        result.add(new ArrayList<>(path));
        //Logic
        IntStream.range(index, nums.length).forEach( i -> {
            //Action
            path.add(nums[i]);
            //Recursion
            helper(nums, i + 1, path);
            //Backtrack
            path.remove(path.size() - 1);
        });
    }
}