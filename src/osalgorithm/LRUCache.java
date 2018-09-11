package osalgorithm;

import java.util.HashMap;
import java.util.LinkedList;

/******************************************************************************
 * Copyright (c) ::                                                           *
 * Creation Date - 11:9:2018,                                                 *
 * Created by - Rakesh Gupta,                                                 *
 * Package - osalgorithm.LRUCacheImpl                                             *
 * Last modified - 9/11/18 11:42 AM                                           *
 * Project Name - DataStructureAlgorithm                                      *
 ******************************************************************************/

public class LRUCache {

    HashMap<Integer, Entry> hashmap;
    Entry start, end;
    int LRU_SIZE = 4;

    public LRUCache() {
        hashmap = new HashMap<>();
    }

    public static void main(String[] args) throws java.lang.Exception {
        // your code goes here
        LRUCache lrucache = new LRUCache();
        lrucache.putEntry(1, 1);
        lrucache.putEntry(10, 15);
        lrucache.putEntry(15, 10);
        lrucache.putEntry(10, 16);
        lrucache.putEntry(12, 15);
        lrucache.putEntry(18, 10);
        lrucache.putEntry(13, 16);

        System.out.println(lrucache.getEntry(1));
        System.out.println(lrucache.getEntry(10));
        System.out.println(lrucache.getEntry(15));

        LinkedList<Integer> linkedList;
    }

    public int getEntry(int key) {

        // Key Already Exist, just update the
        if (hashmap.containsKey(key)) {
            Entry entry = hashmap.get(key);
            removeNode(entry);
            addAtTop(entry);
            return entry.value;
        }
        return -1;
    }

    public void putEntry(int key, int value) {

        // Key Already Exist, just update the value and move it to top
        if (hashmap.containsKey(key)) {
            Entry entry = hashmap.get(key);
            entry.value = value;
            removeNode(entry);
            addAtTop(entry);
        } else {
            Entry newnode = new Entry();
            newnode.left = null;
            newnode.right = null;
            newnode.value = value;
            newnode.key = key;

            if (hashmap.size() > LRU_SIZE) {
                 hashmap.remove(end.key);
                removeNode(end);
                addAtTop(newnode);

            } else {
                addAtTop(newnode);
            }

            hashmap.put(key, newnode);
        }
    }

    public void addAtTop(Entry node) {
        node.right = start;
        node.left = null;
        if (start != null)
            start.left = node;
        start = node;
        if (end == null)
            end = start;
    }

    public void removeNode(Entry node) {

        if (node.left != null) {
            node.left.right = node.right;
        } else {
            start = node.right;
        }

        if (node.right != null) {
            node.right.left = node.left;
        } else {
            end = node.left;
        }
    }

   private static class Entry {
        int value;
        int key;
        Entry left;
        Entry right;
    }
}