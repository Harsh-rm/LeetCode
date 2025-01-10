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

    Solved using two pointers: 
*/

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;

        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;

        while (fast != null) {
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        
        curr.next = prev;

        return curr;
    }

    /*
        Stack based solution -

        Stack<ListNode> s = new Stack<>();
        ListNode curr = dummy.next;

        while (curr != null) {
            s.push(curr);
            curr = curr.next;
        }

        dummy.next = s.pop();
        curr = dummy.next;

        while (!s.isEmpty()) {
            curr.next = s.pop();
            curr = curr.next;
        }

        curr.next = null;
    */
}