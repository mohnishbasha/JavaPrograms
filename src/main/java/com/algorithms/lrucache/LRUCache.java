package com.algorithms.lrucache;

/*

https://www.geeksforgeeks.org/lru-cache-implementation/

https://www.programcreek.com/2013/03/leetcode-lru-cache-java/


We use two data structures to implement an LRU Cache.

Queue which is implemented using a doubly linked list.
The maximum size of the queue will be equal to the total number of frames available (cache size).
The most recently used pages will be near front end and least recently pages will be near the rear end.

A Hash with page number as key and address of the corresponding queue node as value.

 */

/*

Design an LRU cache with a fixed number of entries with the following interface.

class LRUCache<K, V> {

    public LRUCache(int numEntries);

    *  If key already exists, replace the current value with the new value.
    *  If the key doesn't exist, add the new key/value entry to the cache.
    *  If the addition of the new entry causes the number of entries to exceed numEntries, remove the oldest entry based on the last time the entry is accessed (either through put or get).

    public void put(K key, V value);

    // return the value associated with the key or null if the key doesn't exist.
    public V get(K key);
}


Optional: Make the implementation thread-safe.
All candidates should be able to come up with a simple approach with a global lock:
i.e. "synchronized" on get / put functions.

A good candidate may come with some lock-free approach, by asking if the LRU mechanism can be relaxed with concurrent
access to not be strictly obeying calling order. The key point is to use hashmap as the synchronization point,
i.e. the operations are "ordered" by the time they finished on the hashmap, not on the function call time.



 */

import java.util.Map;
import java.util.HashMap;

class Entry<K, V> {
    public Entry<K,V> prev;
    public Entry<K,V> next;

    public final K key;
    public final V value;
    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}

public class LRUCache<K, V> {
    // a linked list in access order; head points to the oldest entry; tail points to the newest entry
    private Entry<K,V> head;
    private Entry<K,V> tail;
    private final Map<K,Entry<K,V>> map = new HashMap<>();
    private final int numEntries;

    public LRUCache(int numEntries) {
        this.numEntries = numEntries;
    }


    /**
     *  If key already exists, replace the current value with the new value.
     *  If the key doesn't exist, add the new key/value entry to the cache.
     *  If the addition of the new entry causes the number of entries to exceed numEntries, remove the oldest entry based on the last time the entry is accessed (either through put or get).
     */
    public void put(K key, V value) {
        Entry<K,V> newEntry = new Entry(key, value);
        // add the new entry to the map
        Entry<K,V> oldEntry = map.put(key, newEntry);
        if (oldEntry != null) {
            // remove the old entry from the linked list
            removeFromLinkedList(oldEntry);
        }
        // add the new entry to the tail of the linked list
        addToTailOfLinkedList(newEntry);
        if (map.size()-1 == numEntries) {
            // remove the head of the linked list
            removeFromLinkedList(head);
            map.remove(head.key);
        }
    }

    // return the value associated with the key or null if the key doesn't exist.
    public V get(K key) {
        Entry<K,V> entry = map.get(key);
        if (entry != null) {
            // move this entry to the tail of the linked list
            removeFromLinkedList(entry);
            addToTailOfLinkedList(entry);
            return entry.value;
        }
        return null;
    }

    private void removeFromLinkedList(Entry<K,V> entry) {
        if (entry.prev != null)
            entry.prev.next = entry.next;
        else
            head = entry.next;


        if (entry.next != null)
            entry.next.prev = entry.prev;
        else
            tail = entry.prev;
    }

    private void addToTailOfLinkedList(Entry<K,V> entry) {
        if (tail == null) {
            head = entry;
            tail = entry;
        } else {
            tail.next = entry;
            entry.prev = tail;
            tail = entry;
        }
    }
}
