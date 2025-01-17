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

    Solved using a DFS-based approach: Refer to the comments in the code to understand the depth!
*/

class Solution {
    //Create a global variable to retain the resultant list
    List<List<Integer>> result;
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();

        if (root == null) return result;

        //DFS based approach
        dfs(root, 0);

        //Return the resultant level order travesed list
        return result;
    }

    private void dfs(TreeNode root, int index) {
        //Base case
        if (root == null) return;

        //Logic
        //If the index is the same as the size of the result list
        if (index == result.size()) {
            //Create a new List at that index of the result list
            result.add(new ArrayList<>());
        }
        //Retrieve the list at the current index of the result list and add the root.val
        result.get(index).add(root.val);

        //Go left and increase the level by one
        dfs(root.left, index + 1);
        //Go right and increase the level by one
        dfs(root.right, index + 1);
    }
}