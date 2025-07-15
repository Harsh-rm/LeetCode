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

    private int startValue, destValue;
    StringBuilder startPath, destPath, result;

    public String getDirections(TreeNode root, int startValue, int destValue) {
        this.startValue = startValue;
        this.destValue = destValue;

        TreeNode lcaNode = findLCA(root);

        //System.out.println(lcaNode.val);

        startPath = new StringBuilder();
        destPath = new StringBuilder();
        result = new StringBuilder();
        
        if (lcaNode != null) { 
            dfs(lcaNode, startValue, startPath);
            dfs(lcaNode, destValue, destPath);
        }

        result.append("U".repeat(startPath.length()));
        result.append(destPath);     

        return result.toString();
    }

    private TreeNode findLCA(TreeNode root) {
        if (root == null) return null;

        if (root.val == startValue || root.val == destValue) return root;

        TreeNode leftNode = findLCA(root.left);

        TreeNode rightNode = findLCA(root.right);

        return (leftNode != null ? (rightNode != null ? root : leftNode) : rightNode);
    }

    private boolean dfs(TreeNode lcaNode, int target, StringBuilder path) {
        //Base case
        if (lcaNode == null) return false;

        if (lcaNode.val == target) return true;

        //Action
        path.append("L");
        if (dfs(lcaNode.left, target, path)) return true;
        path.deleteCharAt(path.length() - 1);        

        path.append("R");
        if (dfs(lcaNode.right, target, path)) return true;
        path.deleteCharAt(path.length() - 1);

        return false;
    }
}