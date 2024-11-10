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
    private TreeNode flattenTree(TreeNode node) {
        if (node == null) {
            return null;
        }
        
        if (node.left == null && node.right == null) {
            return node;
        }
        
        TreeNode leftTail = this.flattenTree(node.left);
        
        TreeNode rightTail = this.flattenTree(node.right);

        if (leftTail != null) {
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }
        
        if (rightTail == null) return leftTail;
        else return rightTail;
    }
    
    public void flatten(TreeNode root) {
        this.flattenTree(root);
    }
}