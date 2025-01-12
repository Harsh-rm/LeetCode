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

        helper(root, 0, new ArrayList<>());

        return result;
    }

    private void helper(TreeNode root, int sum, List<Integer> path) {
        //Base case
        if (root == null) return;
        //Logic - DFS
        path.add(root.val);
        sum += root.val;

        if (root.left == null && root.right == null && sum == target) {
            result.add(path);
            //return;
        }

        helper(root.left, sum, new ArrayList<>(path));
        helper(root.right, sum, new ArrayList<>(path));
    }
}