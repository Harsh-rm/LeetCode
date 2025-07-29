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

    ListNode result;
    Integer k;

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        try {
            this.k = lists.length;
            result = new ListNode(Integer.MIN_VALUE);
            ListNode curr = result;

            for (ListNode li: lists) {
                curr = merge2Lists(curr, li);
            }

            return result.next;
        }
        catch (RuntimeException e) {
            System.err.println("Unchecked exception in mergeKLists -> class Solution: " + e.getMessage());
            return null;
        }
    }

    private ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode curr = head;

        while (l1 != null & l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            }
            else {
                curr.next = l2;
                l2 = l2.next;
            }

            curr = curr.next;
        }

        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }

        return head.next;
    }
}