package javagembasession.firstweek;

/******************************************************************************
 * Copyright (c) ::                                                           *
 * Creation Date - 11:9:2018,                                                 *
 * Created by - Rakesh Gupta,                                                 *
 * Package - javagembasession.firstweek.HashMapCustom                         *
 * Last modified - 9/11/18 2:51 PM                                            *
 * Project Name - DataStructureAlgorithm                                      *
 ******************************************************************************/

public class HashMapCustom<K, V> {

    private Entry<K, V>[] table;

    // Default initial capacity
    static final int capacity = 16;

    // Size of map
    static int size;

    public HashMapCustom() {
        this.table = new Entry[capacity];
    }


    /**
     * Put data in map on given key.
     * @param newKey
     * @param data
     */
    public void put(K newKey, V data) {

        // If key null return
        if (newKey == null)
            return;

        // Calculate custom hash of key for better performance.
        int hash = hash(newKey);

        Entry<K, V> newEntry = new Entry<K, V>(newKey, data, null);

        // Increment size of current map.
        size++;

        if (table[hash] == null) {
            table[hash] = newEntry;
        } else {
            Entry<K, V> previous = null;
            Entry<K, V> current = table[hash];

            while (current != null) {
                if (current.key.equals(newKey)) {
                    if (previous == null) {
                        newEntry.next = current.next;
                        table[hash] = newEntry;
                        return;
                    } else {
                        newEntry.next = current.next;
                        previous.next = newEntry;
                        return;
                    }
                }
                previous = current;
                current = current.next;
            }
            previous.next = newEntry;
        }
    }

    /**
     * Get data from given key from map.
     * @param key
     * @return
     */
    public V get(K key) {
        int hash = hash(key);
        if (table[hash] == null) {
            return null;
        } else {
            Entry<K, V> temp = table[hash];
            while (temp != null) {
                if (temp.key.equals(key))
                    return temp.value;
                temp = temp.next;
            }
            return null;
        }
    }

    public boolean remove(K deleteKey) {

        int hash = hash(deleteKey);

        if (table[hash] == null) {
            return false;
        } else {

            // Decrement size of map.
            size--;

            Entry<K, V> previous = null;
            Entry<K, V> current = table[hash];

            while (current != null) {
                if (current.key.equals(deleteKey)) {
                    if (previous == null) {
                        table[hash] = table[hash].next;
                        return true;
                    } else {
                        previous.next = current.next;
                        return true;
                    }
                }
                previous = current;
                current = current.next;
            }
            return false;
        }

    }

    /**
     *  Custom hash function for generating hash of given key.
     * @param key
     * @return
     */
    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

    /**
     *  Element node of linkedlist.
     * @param <K>
     * @param <V>
     */
    static class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public int size() {
        return size;
    }
}
