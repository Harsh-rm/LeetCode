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
    int sum;
    public int sumNumbers(TreeNode root) {
        if (root == null) return sum;

        dfs(root, sum);

        return sum;
    }

    private void dfs(TreeNode root, int num) {
        //base
        if (root == null) return;
        //logic        
        dfs(root.left, num * 10 + root.val);
        dfs(root.right, num * 10 + root.val);
        //check if root is leaf node - Post-order
        if (root.left == null && root.right == null) {
            sum = sum + num * 10 + root.val;
            return;
        }
    }
}