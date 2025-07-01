/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private TreeNode p, q;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.p = p;
        this.q = q;

        return dfs(root);
    }

    private TreeNode dfs(TreeNode root) {
        //Base case for null node
        if (root == null) {
            return null;
        }
        //Base is check if the root is p or q     
        if (root == p || root == q) {
            return root;
        }

        //Reursion
        TreeNode left = dfs(root.left);
        TreeNode right = dfs(root.right);

        //Condition check for LCA
        /*
        if (left != null && right != null) {
            return root;
        }
        */

        return (left != null) ? (right != null) ? root : left : right;
    }
}