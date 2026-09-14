class Node {
    int key;
    int val;
    Node prev;
    Node next;
    Node(){
        this.prev = null;
        this.next = null;
    }
    Node(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {

    private Node head;
    private Node tail;
    private Map<Integer, Node> cache;
    private int capacity;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        removeNode(node);
        insertNode(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        Node node;
        if(cache.containsKey(key)){
            node = cache.get(key);
            removeNode(node);
            node.val = value;
        }else{
            node = new Node(key, value);
        }
        insertNode(node);
        cache.put(key, node);
        if(cache.size()>capacity){
            cache.remove(tail.prev.key);
            removeNode(tail.prev);
        }
    }

    private void insertNode(Node node){
        Node next = head.next;
        node.next = next;
        next.prev = node;
        head.next = node;
        node.prev = head;
    }

    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
