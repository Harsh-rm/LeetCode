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
            node.prev = head;
            head.next.prev = node;
            head.next = node;

            size++;
        }

        private void removeNode(Node node) {
            node.next.prev = node.prev;
            node.prev.next = node.next;
            //node.next = null;
            //node.prev = null;

            size--;
        }

        private Node removeLastNode() {
            Node lastNode = tail.prev;
            removeNode(lastNode);

            return lastNode;
        }
    }

    int capacity, min;
    HashMap<Integer, Node> keyMap;
    HashMap<Integer, DLList> frequencyMap;    
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        min = 1;
        keyMap = new HashMap<>();
        frequencyMap = new HashMap<>();        
    }
    
    public int get(int key) {
        if(!keyMap.containsKey(key)) return -1;

        Node node = keyMap.get(key);

        update(node);

        return node.value;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;

        if (keyMap.containsKey(key)) {
            Node node = keyMap.get(key);
            update(node);
            node.value = value;
            return;
        }

        if (keyMap.size() == capacity) {
            DLList oldlist =  frequencyMap.get(min);
            Node lastNode = oldlist.removeLastNode();
            keyMap.remove(lastNode.key);
        }

        Node node = new Node(key, value);
        min = 1;
        DLList newlist = frequencyMap.getOrDefault(min, new DLList());
        newlist.addToHead(node);
        frequencyMap.put(min, newlist);
        keyMap.put(key, node);    
    }

    private void update(Node node) {
        //Get the DLList associated with this node's frequency
        DLList oldlist = frequencyMap.get(node.frequency);
        //Remove the node from the DLList
        oldlist.removeNode(node);
        if(min == node.frequency && oldlist.size == 0) {
            min++;
        }
        //Increase the frequency of the node
        node.frequency++;
        //Update the frequencyMap with the updated frequency key
        DLList newlist = frequencyMap.getOrDefault(node.frequency, new DLList());
        //Add the the node to the updated frequency key's list
        newlist.addToHead(node);
        //Add the newlist to update the frequencyMap
        frequencyMap.put(node.frequency, newlist);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */