class Solution {

    private List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        
        try{
            result = new ArrayList<>();

            if (nums == null || nums.length == 0) return result;

            List<Integer> emptyList = new ArrayList<>();

            result.add(emptyList);

            helper(nums);
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    private void helper(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int size = result.size();

            for (int j = 0; j < size; j++) {
                List<Integer> newList = new ArrayList<>(result.get(j));

                newList.add(nums[i]);

                result.add(newList);
            }
        }
    }
}