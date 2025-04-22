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
    
    private List<List<Integer>> result;

    public List<List<Integer>> findLeaves(TreeNode root) {
        result = new ArrayList<>();

        if (root == null) return result;

        helper(root);

        return result;
    }

    private int helper(TreeNode root) {
        //Base case
        if (root == null) {
            return -1;
        }

        //Logic
        int leftHeight = helper(root.left) + 1;
        int rightHeight = helper(root.right) + 1;

        int currHeight = Math.max(leftHeight, rightHeight);

        if (result.size() == currHeight) {
            result.add(new ArrayList<>());
        }

        result.get(currHeight).add(root.val);

        return currHeight;
    }
}