/*
    Leetcode problem 27: Remove Element
    T.C: O(n) :: S.C: O(1)

    Solved using Two pointers: Left and Right. Left starts from index 0 and right starts from index n - 1.
    If the element at index left is equal to k then swap it with the element at right and move right towards the left,
    else move the left forward. If left and right cross each, then break the loop and return the index of the left pointer.
    As the elements until the left pointer have been swapped and they are not equal to k.
*/

class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums == null) return 0;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (nums[left] == val) {
                nums[left] = nums[right];
                right--;
            } else {
                left++;
            }
        }

        return left;
    }
}