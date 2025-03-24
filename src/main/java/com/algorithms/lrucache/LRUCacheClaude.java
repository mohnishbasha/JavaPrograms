package com.algorithms.lrucache;

import java.util.Map;
import java.util.HashMap;

/**
* LRU (Least Recently Used) Cache Implementation
* Uses a HashMap with Doubly Linked List to achieve O(1) operations
*/
public class LRUCacheClaude {

    /**
     * Node class for doubly linked list
     */
    private static class Node {
        int key;
        int value;
        Node prev;
        Node next;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    private final int capacity;
    private final Map<Integer, Node> cache;
    private final Node head;  // Dummy head
    private final Node tail;  // Dummy tail
    
    /**
     * Initialize LRU cache with given capacity
     * @throws IllegalArgumentException if capacity is non-positive
     */
    public LRUCacheClaude(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        
        this.capacity = capacity;
        this.cache = new HashMap<>();
        
        // Initialize dummy head and tail
        this.head = new Node(0, 0);
        this.tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    /**
     * Get value for given key and make it most recently used
     * @return value if found, -1 if not found
     */
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        
        // Move to front (most recently used)
        moveToFront(node);
        return node.value;
    }
    
    /**
     * Add or update key-value pair and make it most recently used
     */
    public void put(int key, int value) {
        Node node = cache.get(key);
        
        if (node != null) {
            // Update existing node
            node.value = value;
            moveToFront(node);
        } else {
            // Create new node
            node = new Node(key, value);
            
            // If at capacity, remove least recently used
            if (cache.size() >= capacity) {
                Node lru = tail.prev;
                removeNode(lru);
                cache.remove(lru.key);
            }
            
            // Add new node
            cache.put(key, node);
            addToFront(node);
        }
    }
    
    /**
     * Move existing node to front of list
     */
    private void moveToFront(Node node) {
        removeNode(node);
        addToFront(node);
    }
    
    /**
     * Add node to front of list
     */
    private void addToFront(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    
    /**
     * Remove node from list
     */
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    /**
     * Get current size of cache
     */
    public int size() {
        return cache.size();
    }
    
    /**
     * Runs all test cases
     */
    public static void runTests() {
        System.out.println("Running LRU Cache Tests");
        System.out.println("======================");
        
        // Test 1: Basic operations
        System.out.println("\nTest 1: Basic operations");
        LRUCacheClaude cache1 = new LRUCacheClaude(2);
        
        cache1.put(1, 1);  // cache=[1:1]
        cache1.put(2, 2);  // cache=[2:2, 1:1]
        System.out.println("get(1): " + cache1.get(1));  // returns 1
        cache1.put(3, 3);  // evicts key 2, cache=[3:3, 1:1]
        System.out.println("get(2): " + cache1.get(2));  // returns -1 (not found)
        cache1.put(4, 4);  // evicts key 1, cache=[4:4, 3:3]
        System.out.println("get(1): " + cache1.get(1));  // returns -1 (not found)
        System.out.println("get(3): " + cache1.get(3));  // returns 3
        System.out.println("get(4): " + cache1.get(4));  // returns 4
        
        // Test 2: Update existing key
        System.out.println("\nTest 2: Update existing key");
        LRUCacheClaude cache2 = new LRUCacheClaude(2);
        cache2.put(1, 1);
        cache2.put(2, 2);
        System.out.println("Initial get(1): " + cache2.get(1));
        cache2.put(1, 10);  // update value
        System.out.println("After update get(1): " + cache2.get(1));
        
        // Test 3: Invalid capacity
        System.out.println("\nTest 3: Invalid capacity");
        try {
            new LRUCacheClaude(0);
            System.out.println("Failed: Should throw exception for zero capacity");
        } catch (IllegalArgumentException e) {
            System.out.println("Passed: Caught invalid capacity");
        }
        
        // Test 4: LRU eviction order
        System.out.println("\nTest 4: LRU eviction order");
        LRUCacheClaude cache4 = new LRUCacheClaude(3);
        cache4.put(1, 1);
        cache4.put(2, 2);
        cache4.put(3, 3);
        cache4.get(1);  // Makes 1 most recently used
        cache4.put(4, 4);  // Should evict 2
        System.out.println("get(1): " + cache4.get(1));  // returns 1
        System.out.println("get(2): " + cache4.get(2));  // returns -1
        System.out.println("get(3): " + cache4.get(3));  // returns 3
        System.out.println("get(4): " + cache4.get(4));  // returns 4
        
        // Test 5: Single capacity cache
        System.out.println("\nTest 5: Single capacity cache");
        LRUCacheClaude cache5 = new LRUCacheClaude(1);
        cache5.put(1, 1);
        cache5.put(2, 2);  // evicts 1
        System.out.println("get(1): " + cache5.get(1));  // returns -1
        System.out.println("get(2): " + cache5.get(2));  // returns 2
    }
    
    public static void main(String[] args) {
        runTests();
    }
 }
