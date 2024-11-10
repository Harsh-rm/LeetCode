/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<List<Integer>> result;
    int target;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) return new ArrayList<>();

        result = new ArrayList<>();
        target = targetSum;

        dfs(root, 0, new ArrayList<>());
        
        return result;
    }

    private void dfs(TreeNode root, int sum, List<Integer> path) {
        //base
        if (root == null) return;
        //logic
        //action
        path.add(root.val);
        sum = sum + root.val;
        //check if root is the leaf node
        if (root.left == null && root.right == null) {
            if (sum == target) {
                result.add(new ArrayList<>(path));
                //System.out.println(path);
                //return;
            }
        }

        //recursion
        dfs(root.left, sum, path);
        dfs(root.right, sum, path);

        //backtracking
        path.remove(path.size() - 1);

    }
}