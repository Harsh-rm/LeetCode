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

    private static class Wrapper {
        TreeNode node;
    }

    public boolean isValidBST(TreeNode root) {        
        try {
            return dfs(root, new Wrapper());
        } 
        catch (RuntimeException e) {
            System.err.println("Un-checked exception in isValidBST -> class Solution: " + e);            
            return false;
        }
        finally {
            //System.out.println("isValidBST is complete!");
        }
    }

    private boolean dfs(TreeNode root, Wrapper prev) {
        if (root == null) return true;

        if (!dfs(root.left, prev)) return false;

        if (prev.node != null && prev.node.val >= root.val) {
            return false;            
        }

        prev.node = root;

        return dfs(root.right, prev);
    }
}