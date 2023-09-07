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
    public void reorderList(ListNode head) {
        if (head == null) return;

        ListNode fast = head;
        ListNode curr = head;
        ListNode slow = head;

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        curr = slow.next;
        slow.next = null;
        slow = slow.next;
        if (curr != null) { 
            fast = curr.next;
            while(fast != null) {
                curr.next = slow;
                slow = curr;
                curr = fast;
                fast = fast.next;
            }
            curr.next = slow;
        }
        // slow = head;
        // while(slow != null) {
        //     System.out.println(slow.val);
        //     slow = slow.next;
        // }

        slow = head;
        fast = head.next;
        while(curr != null) {
            slow.next = curr;
            curr = curr.next;
            // slow = slow.next;
            slow.next.next = fast;
            slow = fast;
            if (fast !=  null) fast = fast.next;
        }
    }
}