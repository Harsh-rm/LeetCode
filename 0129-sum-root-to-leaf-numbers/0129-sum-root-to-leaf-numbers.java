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
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;

        int sum = 0;
        Stack<TreeNode> s = new Stack<>();
        Stack<Integer> numberStack = new Stack<>();
        int tempNumber = 0;

        while(root != null || !s.isEmpty()){
            while(root != null) {
                s.push(root);
                tempNumber = tempNumber * 10 + root.val;
                numberStack.push(tempNumber);
                root = root.left;
            }
            root = s.pop();
            tempNumber = numberStack.pop();
            if (root.left == null && root.right == null) {
                sum = sum + tempNumber;
            }
            root = root.right;
        }
        
        return sum;    
    }
}