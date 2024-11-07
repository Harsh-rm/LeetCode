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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        return checkValidity(root, null, null);
    }

    private boolean checkValidity(TreeNode root, Integer Min, Integer Max) {
        //base
        if (root == null) return true;
        //logic
        if (Max != null && root.val >= Max) return false;
        if (Min != null && root.val <= Min) return false;

        return checkValidity(root.left, Min, root.val) && checkValidity(root.right, root.val, Max);
    }
}