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
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;

        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int num) {
        //base
        if (root == null) return 0;
        //logic        
        int case1 = dfs(root.left, num * 10 + root.val);
        int case2 = dfs(root.right, num * 10 + root.val);

        //check if root is leaf node - Post-order
        if (root.left == null && root.right == null) {
            return num * 10 + root.val;
        }

        return case1 + case2;
    }
}