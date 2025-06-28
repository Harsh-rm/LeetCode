class Solution {

    private List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
         
        try {
            result = new ArrayList<>();

            if (nums == null || nums.length == 0) return result;

            helper(nums, 0, new ArrayList<>());

            return result;
         }
         catch (RuntimeException e) {
            System.out.println(e.getMessage());
         }

         return result;
    }

    private void helper(int[] nums, int index, List<Integer> path) {
        //Capture the path at each recursive call in the result
        result.add(new ArrayList<>(path));
        //Using a for-loop based recursion to re-iterate later occuring indices as a 0-index
        for (int i = index; i < nums.length; i++) {
            //add the current element to path
            path.add(nums[i]);
            //recurse
            helper(nums, i + 1, path);
            //backtrack
            path.remove(path.size() - 1);
        } 
    }
}