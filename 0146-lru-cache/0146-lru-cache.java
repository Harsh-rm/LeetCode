class LRUCache {

    public class Node {
        int key, value;
        Node next, prev;

        public Node() {
            this.key = -1;
            this.value = -1;
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
    }

    Map<Integer, Node> keyMap;
    Node head, tail;
    int capacity;

    public LRUCache(int capacity) {
        keyMap = new HashMap<Integer, Node>();
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        try {
            if (keyMap.containsKey(key)) {
                Node node = keyMap.get(key);
                removeNode(node);
                addToHead(node);                
                return node.value;
            }
            else {
                return -1;
            }
        }
        catch (RuntimeException e) {
            System.err.println("Unchecked exception in get(int) -> class LRUCache: " + e.getMessage());
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            removeNode(node);
            addToHead(node);
            node.value = value;
            return;
        } 
        else {
            if (keyMap.size() == capacity) {
                Node lruNode = tail.prev;
                removeNode(lruNode);
                keyMap.remove(lruNode.key);
            }
            Node node = new Node(key, value);
            keyMap.put(key, node);
            addToHead(node);
            return;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */