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

//Keep track of prev and validate > curr node when moving left
//Keep track of prev and check < curr node when moving right

class Solution {

    private TreeNode prev;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        return dfs(root);
    }

    private boolean dfs(TreeNode root) {
        if (root == null) return true;

        if (!dfs(root.left)) return false;

        if (prev != null && prev.val >= root.val) {
            return false;            
        } else {
            prev = root;
        }

        return dfs(root.right);
    }
}