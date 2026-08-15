import java.util.*;

class LRUCache {

    class Node {

        int key;
        int value;

        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    HashMap<Integer, Node> map;
                                                                
    Node head;                                                                                                                          
    Node tail;
                                                                         
    int capacity;

    public LRUCache(int capacity) {

        this.capacity = capacity;

        map = new HashMap<Integer, Node>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        // Remove from current position
        remove(node);

        // Put at most recent position
        add(node);

        return node.value;
    }

    public void put(int key, int value) {

        // If key already exists
        if (map.containsKey(key)) {

            Node node = map.get(key);

            node.value = value;

            remove(node);

            add(node);

            return;
        }

        // Create new node
        Node node = new Node(key, value);

        map.put(key, node);

        add(node);

        // Cache is full
        if (map.size() > capacity) {

            Node leastRecent = head.next;

            remove(leastRecent);

            map.remove(leastRecent.key);
        }
    }

    // Add node just before tail
    public void add(Node node) {

        Node previous = tail.prev;

        previous.next = node;

        node.prev = previous;

        node.next = tail;

        tail.prev = node;
    }

    // Remove node
    public void remove(Node node) {

        Node previous = node.prev;
        Node next = node.next;

        previous.next = next;
        next.prev = previous;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */