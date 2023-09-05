class LFUCache {

    class Node {
        int key, value, frequency;
        Node next, prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;
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
            node.next = head.next;
            head.next = node;
            node.prev = head;
            node.next.prev = node;
            size++;
        }

        private void removeNode(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            node.next = null;
            node.prev = null;
            size--;
        }

        private Node removeLastNode() {
            Node lastNode = tail.prev;
            removeNode(lastNode);
            return lastNode;
        }
    }

    HashMap<Integer, Node> cache;
    HashMap<Integer, DLList> LFU;
    int capacity, min;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        LFU = new HashMap<>();
        min = 1;
    }
    
    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        update(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(capacity == 0) return;

        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            update(node);
            return;
        } 

        if (cache.size() == capacity) {
            DLList node = LFU.get(min);
            Node lastNode = node.removeLastNode();
            cache.remove(lastNode.key);
        }

        Node node = new Node(key, value);
        min = 1;
        DLList newList = LFU.getOrDefault(min, new DLList());
        newList.addToHead(node);
        cache.put(key, node);
        LFU.put(node.frequency, newList);
    }

    private void update(Node node) {
        //get node's frequency
        int frequency = node.frequency;
        //remove the node from LFU map and update the use_counter
        DLList oldList = LFU.get(frequency);
        //remove the node from the DLList to add it with the next frequency count
        oldList.removeNode(node);
        //check is the frequency is minimum and the DLLList with current frequency is empty
        if(min == frequency && oldList.size == 0) {
            min++;
        }
        //Increase the frequency of the node
        node.frequency++;
        //Add the node to LFU containing the new frequency
        DLList newList = LFU.getOrDefault(node.frequency, new DLList());
        //add the node to this new list from the LFU
        newList.addToHead(node);
        //add the newlist to the LFU map
        LFU.put(node.frequency, newList);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */