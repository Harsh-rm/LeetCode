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

    private int src, dest;
    private StringBuilder srcPath, destPath;
    private StringBuilder directions;

    public String getDirections(TreeNode root, int startValue, int destValue) {
        if (root == null) return "";

        try {
            this.src = startValue;
            this.dest = destValue;
            this.srcPath = new StringBuilder();
            this.destPath = new StringBuilder();
            this.directions = new StringBuilder();

            TreeNode node = findLCA(root);

            findPath(node, src, srcPath);
            findPath(node, dest, destPath);

            // Add "U" for each step to go up from start to LCA
            directions.append("U".repeat(srcPath.length()));

            // Append the path from LCA to destination
            directions.append(destPath);

        } catch (Exception e) {
            System.out.println("Unchecked Exception in getDirestions: " + e);
        }
        
        return directions.toString();
    }

    private TreeNode findLCA(TreeNode root) {
        //Base case
        if (root == null) return null;

        if (root.val == src || root.val == dest) {
            return root;
        }

        //Logic
        TreeNode leftNode = findLCA(root.left);
        TreeNode rightNode = findLCA(root.right);

        if (rightNode == null) return leftNode;
        else if (leftNode == null) return rightNode;
        
        return root;
    }

    private boolean findPath(TreeNode node, int target, StringBuilder path) {
        //Base case
        if (node == null) return false;

        if (node.val == target) return true;

        //Logic
        path.append("L");
        if (findPath(node.left, target, path)) {
            return true;
        }
        path.setLength(path.length() - 1);

        path.append("R");
        if (findPath(node.right, target, path)) {
            return true;
        }
        path.setLength(path.length() - 1);

        return false;
    }
}