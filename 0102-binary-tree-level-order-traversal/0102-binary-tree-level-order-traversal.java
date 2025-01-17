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

/*
    Leetcode problem 102: Binary Tree Level Order Traversal
    T.C: O(n) :: S.C: O(n) - Space occupied by the Queue

    Solved using BFS: Initialize an empty Queue of TreeNodes with the root (If the root is null, return an empty ArrayList immediately).
    Then traverse through the Queue by maintianing a size variable for keeping track of each level in the tree (i.e initially size is 1
    add this element as a new list to the result), go left, and go right, and then add the child if it is not null. Now when you are at 
    the second level (the size is 2). Repeat this process to retrieve the level order traversal of the Binary tree.
*/

class Solution {
    List<List<Integer>> result;
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> li = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                li.add(curr.val);

                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }

            result.add(li);
        }

        return result;
    }
}