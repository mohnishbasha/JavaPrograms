package com.algorithms.lfucache;

import java.util.*;

/**
 * LFU (Least Frequently Used) Cache Implementation
 * Keeps track of frequency of access and evicts least frequently used items
 */
public class LFUCache {
    private final int capacity;
    private int minFrequency;
    private final Map<Integer, Node> keyMap;  // Key -> Node mapping
    private final Map<Integer, LinkedHashSet<Node>> freqMap;  // Frequency -> Set of nodes
    
    /**
     * Node class to store key, value, and access frequency
     */
    private static class Node {
        int key;
        int value;
        int frequency;
        
        Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.frequency = 1;  // Start with frequency 1
        }
    }
    
    /**
     * Initialize LFU cache with given capacity
     * @throws IllegalArgumentException if capacity is non-positive
     */
    public LFUCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        
        this.capacity = capacity;
        this.minFrequency = 0;
        this.keyMap = new HashMap<>();
        this.freqMap = new HashMap<>();
    }
    
    /**
     * Get value for given key and update access frequency
     * @return value if found, -1 if not found
     */
    public int get(int key) {
        Node node = keyMap.get(key);
        if (node == null) {
            return -1;
        }
        
        updateFrequency(node);
        return node.value;
    }
    
    /**
     * Put key-value pair in cache
     * If key exists, update value and frequency
     * If cache is full, remove least frequently used item
     */
    public void put(int key, int value) {
        // Special case: capacity = 0
        if (capacity == 0) {
            return;
        }
        
        Node node = keyMap.get(key);
        
        if (node != null) {
            // Update existing node
            node.value = value;
            updateFrequency(node);
        } else {
            // Create new node
            node = new Node(key, value);
            
            // If cache is full, remove least frequently used
            if (keyMap.size() >= capacity) {
                removeLFU();
            }
            
            // Add new node
            keyMap.put(key, node);
            minFrequency = 1;  // New nodes start at frequency 1
            freqMap.computeIfAbsent(1, k -> new LinkedHashSet<>()).add(node);
        }
    }
    
    /**
     * Update frequency of accessed node
     */
    private void updateFrequency(Node node) {
        int freq = node.frequency;
        
        // Remove from current frequency set
        freqMap.get(freq).remove(node);
        if (freqMap.get(freq).isEmpty()) {
            freqMap.remove(freq);
            // Update minFrequency if needed
            if (freq == minFrequency) {
                minFrequency++;
            }
        }
        
        // Add to new frequency set
        node.frequency++;
        freqMap.computeIfAbsent(node.frequency, k -> new LinkedHashSet<>()).add(node);
    }
    
    /**
     * Remove least frequently used item
     */
    private void removeLFU() {
        LinkedHashSet<Node> minFreqSet = freqMap.get(minFrequency);
        Node lfu = minFreqSet.iterator().next();  // Get first (oldest) item
        minFreqSet.remove(lfu);
        keyMap.remove(lfu.key);
        
        if (minFreqSet.isEmpty()) {
            freqMap.remove(minFrequency);
        }
    }
    
    /**
     * Get current size of cache
     */
    public int size() {
        return keyMap.size();
    }
    
    /**
     * Runs all test cases
     */
    public static void runTests() {
        System.out.println("Running LFU Cache Tests");
        System.out.println("======================");
        
        // Test 1: Basic operations
        System.out.println("\nTest 1: Basic operations");
        LFUCache cache1 = new LFUCache(2);
        
        cache1.put(1, 1);  // cache=[1:1]
        cache1.put(2, 2);  // cache=[1:1, 2:2]
        System.out.println("get(1): " + cache1.get(1));  // return 1
        cache1.put(3, 3);  // evicts key 2, cache=[1:1, 3:3]
        System.out.println("get(2): " + cache1.get(2));  // return -1 (not found)
        System.out.println("get(3): " + cache1.get(3));  // return 3
        cache1.put(4, 4);  // evicts key 1, cache=[4:4, 3:3]
        System.out.println("get(1): " + cache1.get(1));  // return -1 (not found)
        System.out.println("get(3): " + cache1.get(3));  // return 3
        System.out.println("get(4): " + cache1.get(4));  // return 4
        
        // Test 2: Update existing key
        System.out.println("\nTest 2: Update existing key");
        LFUCache cache2 = new LFUCache(2);
        cache2.put(1, 1);
        cache2.put(2, 2);
        System.out.println("Initial get(1): " + cache2.get(1));
        cache2.put(1, 10);  // update value
        System.out.println("After update get(1): " + cache2.get(1));
        
        // Test 3: Zero capacity
        System.out.println("\nTest 3: Zero capacity");
        try {
            new LFUCache(0);
            System.out.println("Failed: Should throw exception for zero capacity");
        } catch (IllegalArgumentException e) {
            System.out.println("Passed: Caught invalid capacity");
        }
        
        // Test 4: Frequency-based eviction
        System.out.println("\nTest 4: Frequency-based eviction");
        LFUCache cache4 = new LFUCache(3);
        cache4.put(1, 1);
        cache4.put(2, 2);
        cache4.put(3, 3);
        cache4.get(1);  // frequency=2
        cache4.get(1);  // frequency=3
        cache4.get(2);  // frequency=2
        cache4.put(4, 4);  // evicts key 3 (lowest frequency)
        System.out.println("get(1): " + cache4.get(1));  // return 1
        System.out.println("get(2): " + cache4.get(2));  // return 2
        System.out.println("get(3): " + cache4.get(3));  // return -1
        System.out.println("get(4): " + cache4.get(4));  // return 4
        
        // Test 5: Edge cases
        System.out.println("\nTest 5: Edge cases");
        LFUCache cache5 = new LFUCache(1);
        cache5.put(1, 1);
        cache5.put(2, 2);  // evicts 1
        System.out.println("get(1): " + cache5.get(1));  // return -1
        System.out.println("get(2): " + cache5.get(2));  // return 2
    }
    
    public static void main(String[] args) {
        runTests();
    }
}