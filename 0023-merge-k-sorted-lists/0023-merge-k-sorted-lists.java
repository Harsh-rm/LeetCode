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
    int k;

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        try {
            this.k = lists.length;
            result = new ListNode(-1);
            ListNode curr = result;

            PriorityQueue<ListNode> pq = new PriorityQueue<>(k, (a,b) -> a.val - b.val);

            for (ListNode head: lists) {
                if (head != null) pq.add(head);
            }

            while (!pq.isEmpty()) {
                ListNode min = pq.poll();
                curr.next = min;
                curr = min;
                if (min.next != null) pq.add(min.next);
            }

            return result.next;
        }
        catch (RuntimeException e) {
            System.err.println("Unchecked exception in mergeKLists -> class Solution: " + e.getMessage());
            return null;
        }
    }
}