class LFUCache {

    class Node {
        int key, value, freq;
        Node next, prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.freq = 1;
        }
    }

    class DLList {
        Node head, tail;
        int size;

        public DLList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }

        private void addToHead(Node node) {
            head.next.prev = node;
            node.next = head.next;
            head.next = node;
            node.prev = head;
            size++;
        }

        private void removeNode(Node node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.next = null;
            node.prev = null;
            size--;
        }

        private Node removeLastNode() {
            Node lruNode = tail.prev;
            removeNode(lruNode);

            return lruNode;
        }
    }

    Map<Integer, Node> keyMap;
    Map<Integer, DLList> lfuCache;
    int capacity, min;

    public LFUCache(int capacity) {
        this.keyMap = new HashMap<>();
        this.lfuCache = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (!keyMap.containsKey(key)) return -1;

        Node node = keyMap.get(key);
        updateLFUCache(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            node.value = value;
            updateLFUCache(node);
            return;
        }
        
        if (capacity == keyMap.size()) {
            DLList list = lfuCache.get(min);
            Node node = list.removeLastNode();
            keyMap.remove(node.key);
        }

        min = 1;
        Node node = new Node(key, value);
        keyMap.put(key, node);
        DLList list = lfuCache.getOrDefault(min, new DLList());
        list.addToHead(node);
        lfuCache.put(min, list);
    }

    private void updateLFUCache(Node node) {
        DLList oldList = lfuCache.get(node.freq);

        oldList.removeNode(node);

        if (node.freq == min && oldList.size == 0) {
            min++;
        }
        node.freq++;

        DLList newList = lfuCache.getOrDefault(node.freq, new DLList());

        newList.addToHead(node);

        lfuCache.put(node.freq, newList);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */