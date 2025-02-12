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
    private boolean result;

    public boolean isCousins(TreeNode root, int x, int y) {
        result = false;

        if (root == null) return result;

        int x_parent = 0;
        int y_parent = 0;
        Queue<TreeNode> bfs = new LinkedList<>();
        boolean flag = false;

        bfs.add(root);

        while(!bfs.isEmpty()) {
            int size = bfs.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode curr = bfs.poll();

                if (curr.left != null) {
                    bfs.add(curr.left);
                }

                if (curr.right != null) {
                    bfs.add(curr.right);
                }

                if ((curr.left!= null && curr.left.val == x) || (curr.right != null && curr.right.val == x)) {
                    x_parent = curr.val;
                }

                if ((curr.left!= null && curr.left.val == y) || (curr.right != null && curr.right.val == y)) {
                    y_parent = curr.val;
                }

                if (curr.val == x && x_parent != y_parent) {
                    if (flag) {
                        result = true;
                    } else {
                        flag = true;
                    }
                } else if (curr.val == x && x_parent == y_parent) {
                    return false;
                } 

                if (curr.val == y && x_parent != y_parent) {
                    if (flag) {
                        result = true;
                    } else {
                        flag = true;
                    }
                } else if (curr.val == y && x_parent == y_parent) {
                    return false;
                } 
            }

            if (flag) {
                flag = false;
            }

        }

        return result;
    }
}