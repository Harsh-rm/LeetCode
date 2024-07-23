class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return result;

        helper(candidates, 0, target, new ArrayList<>());

        return result;
    }

    private void helper(int[] candidates, int index, int target, List<Integer> path) {
        //Base
        if (target < 0 || index == candidates.length) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        //Logic
        //Do not choose or 0 case
        helper(candidates, index + 1, target, path);
        //Choose or 1 case
        //Action
        path.add(candidates[index]);
        //Recurse
        helper(candidates, index, target - candidates[index], path);
        //Backtrack
        path.remove(path.size() - 1);
    }
}