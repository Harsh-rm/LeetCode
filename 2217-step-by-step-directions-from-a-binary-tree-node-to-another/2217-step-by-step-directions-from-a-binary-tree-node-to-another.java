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

    private StringBuilder srcPath, destPath;
    private StringBuilder dir;

    public String getDirections(TreeNode root, int startValue, int destValue) {
        if (root == null) return "";

        srcPath = new StringBuilder();
        destPath = new StringBuilder();
        dir = new StringBuilder();

        TreeNode lca = this.findLCA(root, startValue, destValue);
        
        if (lca != null) {
            findPath(lca, startValue, srcPath);
            findPath(lca, destValue, destPath);
        }

        dir.append("U".repeat(srcPath.length()));

        dir.append(destPath);

        return dir.toString();
    }

    private TreeNode findLCA(TreeNode root, int s, int d) {
        if (root == null) return null;

        if (root.val == s || root.val == d) return root;

        TreeNode leftNode = findLCA(root.left, s, d);
        TreeNode rightNode = findLCA(root.right, s, d);

        return (leftNode != null) ? ((rightNode != null) ? root : leftNode) : rightNode;
    }

    private boolean findPath(TreeNode node, int val, StringBuilder path) {
        if (node == null) return false;

        if (node.val == val) return true;

        path.append("L");
        if (findPath(node.left, val, path)) return true;
        path.setLength(path.length() - 1);

        path.append("R");
        if (findPath(node.right, val, path)) return true;
        path.setLength(path.length() - 1);

        return false;
    }


}