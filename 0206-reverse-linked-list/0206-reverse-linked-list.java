/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/*
    Leetcode problem 206: Reverse a Linked List
    T.C: O(n) :: S.C: O(1)

    Solved using three pointers: Previous pointing to null, Current pointing to 
*/

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;

        ListNode dummy = new ListNode(Integer.MIN_VALUE, head);

        ListNode prev = head;
        ListNode curr = head;
        ListNode fast = head.next;

        while (fast != null) {
            dummy.next = fast;
            fast = fast.next;
            curr.next = fast;
            dummy.next.next = prev;
            prev = dummy.next;
        }
        curr.next = fast;

        return dummy.next;
    }
}