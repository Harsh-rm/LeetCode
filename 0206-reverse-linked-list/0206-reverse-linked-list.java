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

        ListNode dummy = new ListNode(Integer.MIN_VALUE, head);
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
/*
        ListNode curr = dummy;
        ListNode ahead = dummy.next;

        while (ahead != null && ahead.next != null) {
            ListNode prev = dummy.next;
            dummy.next = ahead;
            ahead = ahead.next;
            dummy.next.next = prev;
            curr.next = ahead;
            curr = ahead;

            System.out.println(dummy.next.val);
        }
*/
        return dummy.next;
    }
}