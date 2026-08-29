class Node {
    int key, val;
    Node prev, next;

    Node(int key, int val){
        this.key = key;
        this.val = val;
        this.prev=null;
        this.next=null;
    }
}

class LRUCache {

    Map<Integer,Node> cache;
    int capacity;
    Node left;
    Node right;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        left = new Node(0,0);
        right = new Node(0,0);
        left.next=right;
        right.prev=left;
    }
    
    public int get(int key) {
        if(!cache.containsKey(key))
            return -1;
        Node node = cache.get(key);
        remove(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.val = value;
            remove(node);
        }
        Node newNode = new Node(key,value);
        cache.put(key,newNode);
        insert(newNode);
        if(cache.size()>capacity){
            Node lru = left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }

    private void remove(Node node){
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    private void insert(Node node){
        node.prev = right.prev;
        right.prev.next = node;
        right.prev = node;
        node.next = right;
    }
}
