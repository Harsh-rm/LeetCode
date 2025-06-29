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
    public ListNode mergeKLists(ListNode[] lists) {        

        try {
            if (lists == null || lists.length == 0) return null;

            int amount = lists.length;
            int interval = 1;

            while (interval < amount) {
                for (int i = 0; i < amount - interval; i += interval * 2) {
                    lists[i] = this.merge2Lists(lists[i], lists[i + interval]);
                }

                interval *= 2;
            }
        }
        catch(RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }

        return lists[0];
    }

    private ListNode merge2Lists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode point = head;

        try {
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    point.next = l1;
                    l1 = l1.next;
                } else {
                    point.next = l2;
                    l2 = l2.next;
                }

                point = point.next;
            }

            point.next = (l1 != null) ? l1 : l2;            
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }

        return head.next;
    }
}