/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {

    private Map<Node, Node> nodeCopyMap;

    public Node copyRandomList(Node head) {
        if (head == null) return head;

        nodeCopyMap = new HashMap<>();

        Node dummy = new Node(Integer.MIN_VALUE);
        dummy.next = head;
        Node curr = dummy;

        while (curr.next != null) {
            curr = curr.next;

            nodeCopyMap.putIfAbsent(curr, new Node(curr.val));

            if (curr.next != null) {
                nodeCopyMap.putIfAbsent(curr.next, new Node(curr.next.val));
                nodeCopyMap.get(curr).next = nodeCopyMap.get(curr.next);
            }

            if (curr.random != null) {
                nodeCopyMap.putIfAbsent(curr.random, new Node(curr.random.val));
                nodeCopyMap.get(curr).random = nodeCopyMap.get(curr.random);
            }
        }

        dummy.next = nodeCopyMap.get(dummy.next);

        return dummy.next;
    }
}