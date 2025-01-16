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
class Solution {
    ListNode reversed;

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode temp = helper(head);
        temp.next = null;

        return reversed;
    }

    private ListNode helper(ListNode head) {
        if (head.next == null) {
            reversed = head;
            return head;
        }

        ListNode temp = helper(head.next);

        temp.next = head;
        temp = temp.next;

        return temp;
    }
}