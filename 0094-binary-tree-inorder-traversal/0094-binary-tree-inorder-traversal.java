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
    private List<Integer> result;

    public List<Integer> inorderTraversal(TreeNode root) {
        result = new ArrayList<>();

        if (root == null) return result;

        helper(root);

        return result;
    }

    public void helper(TreeNode root) {
        //Base case
        if (root == null) return;

        if (root.left == null && root.right == null) {
            result.add(root.val);
            return;
        }

        helper(root.left);

        result.add(root.val);

        helper(root.right);
    }
}