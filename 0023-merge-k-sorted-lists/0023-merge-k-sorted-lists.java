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
    Integer amount, interval;

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null ||  lists.length == 0) return null;

        try {
            this.amount = lists.length;
            this.interval = 1;

            while (interval < amount) {
                for (int i = 0; i < amount - interval; i += interval * 2) {
                    lists[i] = merge2Lists(lists[i], lists[i + interval]);
                }

                interval *= 2;
            }

            return lists[0];
        }
        catch (RuntimeException e) {
            System.err.println("Unchecked exception in mergeKLists(ListNode[] ) -> class Solution: " + e.getMessage());
            return null;
        }
    }

    private ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode curr = head;

        while (l1 != null && l2 != null) {
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

        curr.next = (l1 == null) ? l2 : l1;

        return head.next;
    }
}