package pepcoding;

import java.util.HashMap;
import java.util.Map;

public class LruCacheImpl{
    public static void main(String[] args) {
        LruCache lruCache = new LruCache(3);
        lruCache.put(3,30);
        int p1 = lruCache.get(2);
        System.out.println(p1);
    }
}

class LruCache {
    Node head = new Node(0,0);
    Node tail = new Node(0,0);
    Map<Integer,Node> map = new HashMap<>();
    int capacity ;

    public LruCache(int capacity){
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }else{
            return -1;
        }
    }
    public void put(int key , int value){
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size() == capacity){
            remove(tail.prev);
        }
        insert(new Node(key,value));
    }

    private void remove(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node){
        map.put(node.key,node);
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;
    }
}

class Node {
    Node prev, next;
    int key, value;

    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}

