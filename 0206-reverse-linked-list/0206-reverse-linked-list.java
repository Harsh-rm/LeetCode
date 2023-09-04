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
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode slow = null;
        ListNode curr = head;
        ListNode fast = head.next;

        while(fast != null) {
            curr.next = slow;
            slow = curr;
            curr = fast;
            fast = fast.next;
        }
        curr.next = slow;
        
        return curr;
    }
}