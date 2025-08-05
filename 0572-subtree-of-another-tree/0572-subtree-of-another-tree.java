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

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) return false;

        Deque<TreeNode> bfs = new ArrayDeque<>();
        bfs.add(root);

        while (!bfs.isEmpty()){
            int size = bfs.size();

            for (int i = 0; i < size; i++) {
                TreeNode curr = bfs.poll();

                if (curr.val == subRoot.val) {
                    if (isIdentical(curr, subRoot)) return true;
                }

                if(curr.left != null) {
                    bfs.add(curr.left);
                }
                if (curr.right != null) {
                    bfs.add(curr.right);
                }                
            }
        }

        return false;
    }

    private boolean isIdentical(TreeNode subTree, TreeNode subRoot) {
        if (subTree == null && subRoot == null) {
            return true;
        }
        else if (subTree == null || subRoot == null) {
            return false;
        }

        if (subTree.val != subRoot.val) {
            return false;
        }

        return isIdentical(subTree.left, subRoot.left) && isIdentical(subTree.right, subRoot.right);
    }
}