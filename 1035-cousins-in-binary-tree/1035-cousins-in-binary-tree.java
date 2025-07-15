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

    private static class Wrapper {
        int level;
        TreeNode node;

        Wrapper(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    private Wrapper xParent, yParent;

    public boolean isCousins(TreeNode root, int x, int y) {
        try {

            xParent = dfs(root, null, x, 0);
            yParent = dfs(root, null, y, 0);

            if (xParent.node.val != yParent.node.val && xParent.level == yParent.level) return true;
            
            return false;
        }
        catch (RuntimeException e) {
            System.err.println("Un-checked exception at isCousins() -> class Solution: " + e.getMessage());
            return false;
        }
        finally {
            //System.out.println("isCousins executed successfully!");
        }
    }

    private static Wrapper dfs(TreeNode root, TreeNode prev, int target, int level) {
        if (root == null) return null;

        if (root.val == target) {
            return new Wrapper (prev,  level);
        }

        Wrapper left = dfs(root.left, root, target, level + 1);
        if (left != null) return left;

        Wrapper right = dfs(root.right, root, target, level + 1);
        return right;
    }
}