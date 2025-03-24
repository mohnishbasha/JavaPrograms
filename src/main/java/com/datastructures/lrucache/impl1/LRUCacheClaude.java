package com.datastructures.lrucache.impl1;

import java.util.*;

/**
 * LRU (Least Recently Used) Cache implementation
 * Uses doubly linked list and hash map for O(1) operations
 */
public class LRUCacheClaude {
    /**
     * Node class for doubly linked list to track access order
     */
    private class Node {
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
     * Get value by key and make it most recently used
     * @return value if found, -1 if not found
     */
    public int get(int key) {
        Node node = cache.get(key);
        if (node == null) {
            return -1;
        }
        
        // Make node most recently used
        moveToFront(node);
        return node.value;
    }
    
    /**
     * Put key-value pair into cache
     * If key exists, update value and make most recently used
     * If cache is full, remove least recently used item
     */
    public void put(int key, int value) {
        Node node = cache.get(key);
        
        if (node != null) {
            // Update existing node
            node.value = value;
            moveToFront(node);
        } else {
            // Create new node
            Node newNode = new Node(key, value);
            
            // Remove least recently used if cache is full
            if (cache.size() >= capacity) {
                Node lru = tail.prev;
                removeNode(lru);
                cache.remove(lru.key);
            }
            
            // Add new node
            cache.put(key, newNode);
            addToFront(newNode);
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
        testPut(cache1, 1, 1);
        testPut(cache1, 2, 2);
        testGet(cache1, 1, 1);  // returns 1
        testPut(cache1, 3, 3);  // evicts key 2
        testGet(cache1, 2, -1); // returns -1 (not found)
        testPut(cache1, 4, 4);  // evicts key 1
        testGet(cache1, 1, -1); // returns -1 (not found)
        testGet(cache1, 3, 3);  // returns 3
        testGet(cache1, 4, 4);  // returns 4

        // Test 2: Update existing key
        System.out.println("\nTest 2: Update existing key");
        LRUCacheClaude cache2 = new LRUCacheClaude(2);
        testPut(cache2, 1, 1);
        testPut(cache2, 1, 10); // update value
        testGet(cache2, 1, 10);

        // Test 3: Invalid capacity
        System.out.println("\nTest 3: Invalid capacity");
        try {
            new LRUCacheClaude(0);
            System.out.println("Failed: Should throw exception for zero capacity");
        } catch (IllegalArgumentException e) {
            System.out.println("Passed: Caught zero capacity");
        }

        try {
            new LRUCacheClaude(-1);
            System.out.println("Failed: Should throw exception for negative capacity");
        } catch (IllegalArgumentException e) {
            System.out.println("Passed: Caught negative capacity");
        }

        // Test 4: Access order testing
        System.out.println("\nTest 4: Access order testing");
        LRUCacheClaude cache4 = new LRUCacheClaude(3);
        testPut(cache4, 1, 1);
        testPut(cache4, 2, 2);
        testPut(cache4, 3, 3);
        testGet(cache4, 1, 1);  // makes 1 most recently used
        testPut(cache4, 4, 4);  // should evict 2
        testGet(cache4, 2, -1); // 2 should be evicted
        testGet(cache4, 1, 1);  // 1 should still exist
        testGet(cache4, 3, 3);  // 3 should still exist
        testGet(cache4, 4, 4);  // 4 should exist

        // Test 5: Single capacity cache
        System.out.println("\nTest 5: Single capacity cache");
        LRUCacheClaude cache5 = new LRUCacheClaude(1);
        testPut(cache5, 1, 1);
        testPut(cache5, 2, 2);  // evicts 1
        testGet(cache5, 1, -1); // 1 should be evicted
        testGet(cache5, 2, 2);  // 2 should exist
    }

    /**
     * Helper method to test put operation
     */
    private static void testPut(LRUCacheClaude cache, int key, int value) {
        try {
            cache.put(key, value);
            System.out.printf("Put (%d,%d) - Cache size: %d%n", 
                key, value, cache.size());
        } catch (Exception e) {
            System.out.println("Put failed: " + e.getMessage());
        }
    }

    /**
     * Helper method to test get operation
     */
    private static void testGet(LRUCacheClaude cache, int key, int expected) {
        try {
            int result = cache.get(key);
            System.out.printf("Get %d: Expected %d, Got %d - %s%n",
                key, expected, result,
                result == expected ? "PASSED" : "FAILED");
        } catch (Exception e) {
            System.out.println("Get failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        runTests();
    }
}