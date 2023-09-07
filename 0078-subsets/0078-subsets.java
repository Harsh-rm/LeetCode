class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        int n = nums.length;
        
        if (nums == null || nums.length == 0) return result;
        
        result.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            int size = result.size();
            for(int j = 0; j < size; j++) {
                List<Integer> newList = new ArrayList<>(result.get(j));
                newList.add(nums[i]);
                result.add(newList);
            }
        }

        return result;
    }
}