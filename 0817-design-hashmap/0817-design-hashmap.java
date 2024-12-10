class MyHashMap {

    class Node {
        int key, value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;            
        }
    }

    Node[] nodes;
    private int buckets;
    
    private int getBucket(int key) {
        return Integer.hashCode(key) % buckets;
    }

    public MyHashMap() {
        buckets = 10000;
        nodes = new Node[buckets];
    }

    private Node find(Node node, int key) {
        Node prev = node;
        Node curr = node.next;
        
        while (curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }

        return prev;
    }
    
    public void put(int key, int value) {
        int bucket = getBucket(key);
        //Check if bucket is null - i.e Node list does not exist at index with hash property of key
        if (nodes[bucket] == null) {
            //create a dummy node
            nodes[bucket] = new Node(-1, -1);
        }
        //Find if Node with key already exists
        Node prev = find(nodes[bucket], key);
        if (prev.next == null) { //Key does not exist
            prev.next = new Node(key, value);
        }
        else { //key exist
            prev.next.value = value;
        }
    }
    
    public int get(int key) {
        int bucket = getBucket(key);
        //Check if bucket is null
        if (nodes[bucket] == null) {
            return -1;
        }
        //Find if Node with key exist to return the value
        Node prev = find(nodes[bucket], key);
        if (prev.next == null) { //Key does not exist
            return -1;
        }

        return prev.next.value;
    }
    
    public void remove(int key) {
        int bucket = getBucket(key);
        //Check if bucket is null
        if (nodes[bucket] == null) {
            return;
        }
        //Find if Node with key exist to return the value
        Node prev = find(nodes[bucket], key);
        if (prev.next == null) { //Key does not exist
            return;
        }
        else { //Key exist - remove this node from the Node list for this nodes[bucket] item
            Node pair = prev.next;
            prev.next = prev.next.next;
            pair.next = null;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */