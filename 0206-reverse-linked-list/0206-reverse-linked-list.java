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

    I solved this problem in an unorthodox approach, unlike the regular way of reversing 
    the pointers for each node to its previous.

    Solved using three pointers: Previous pointing to head, Current pointing to the head
    and front (as next is used as a reference in the class ListNode) point to the node next
    to head. Now, we make the dummy point to the front node and then move front to the next node, 
    typically we are traversing through the linked list and then sending each of the nodes to the
    head and making sure the linked list has the proper chain, where all the nodes are connected w.r.t
    to the original links. Refer the comments in the code to understand better.
*/

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;

        ListNode dummy = new ListNode(Integer.MIN_VALUE, head);

        ListNode prev = head;
        ListNode curr = head;
        ListNode front = head.next;

        while (front != null) {
            //Bring the node in the front to the head
            dummy.next = front;
            //Now move front to the next position in LL
            front = front.next;
            //Organize the LL by making sure the initial head is always connected to the front node
            curr.next = front;
            //Now connect the current head to the previous head
            dummy.next.next = prev;
            //Make the current head as the previous head of the LL
            prev = dummy.next;
        }
        //To avoid LL cyle make sure the initial head points to null
        curr.next = front;

        //Return the dummy's next (which is the new head)
        return dummy.next;
    }
}