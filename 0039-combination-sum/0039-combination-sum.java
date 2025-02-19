class Solution {
    private List<List<Integer>> result;
    private int[] dp;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();

        if (candidates == null || candidates.length == 0) return result;

        dp = new int[target + 1];

        helper(candidates, target, 0, new ArrayList<>());

        return result;
    }

    private void helper(int[] candidates, int target, int index, List<Integer> path) {
        //Base case
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (index == candidates.length || target < 0) {
            return;
        }
        //Logic
        for (int i = index; i < candidates.length; i++) {
            List<Integer> newList = new ArrayList<>(path);
            newList.add(candidates[i]);
            helper(candidates, target - candidates[i], i, newList);
        }
    }
}