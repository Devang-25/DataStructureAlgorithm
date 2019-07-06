package osalgorithm;

import java.util.HashMap;

/**
 * **************************************************************************** Copyright (c) :: *
 * Creation Date - 14:9:2018, * Created by - Rakesh Gupta, * Package - osalgorithm.LRUCacheImpl *
 * Last modified - 9/14/18 2:54 PM * Project Name - DataStructureAlgorithm *
 * ****************************************************************************
 */
public class LRUCacheImpl {

    // Size of LRU Cache.
    private static final int LRU_SIZE = 4;
    private HashMap<Integer, EntryNode> mapImpl;
    private EntryNode start, end;

    public LRUCacheImpl() {
        mapImpl = new HashMap<>();
    }

    public static void main(String[] args) {

        LRUCacheImpl cache = new LRUCacheImpl();
        cache.putEntry(1, 1);
        cache.putEntry(10, 10);
        cache.putEntry(15, 15);
        cache.putEntry(55, 55);

        cache.printLRUCache(cache.start);
        System.out.println(cache.getEntry(1));
        cache.printLRUCache(cache.start);
        System.out.println(cache.getEntry(10));
        cache.printLRUCache(cache.start);
        System.out.println(cache.getEntry(15));
        cache.printLRUCache(cache.start);
    }

    public int getEntry(int key) {

        if (mapImpl.containsKey(key)) {
            EntryNode entry = mapImpl.get(key);
            removeNode(entry);
            addAtTop(entry);
            return entry.value;
        }
        // If no key is found then return -1.
        return -1;
    }

    public void putEntry(int key, int value) {

        if (mapImpl.containsKey(key)) {
            EntryNode entry = mapImpl.get(key);
            entry.value = value;
            removeNode(entry);
            addAtTop(entry);
        } else {
            EntryNode newnode = new EntryNode();
            newnode.left = null;
            newnode.right = null;
            newnode.value = value;
            newnode.key = key;

            // Decrease one for index and size sync.
            if (mapImpl.size() > (LRU_SIZE - 1)) {
                mapImpl.remove(end.key);
                removeNode(end);
                addAtTop(newnode);

            } else {
                addAtTop(newnode);
            }

            mapImpl.put(key, newnode);
        }
    }

    public void addAtTop(EntryNode node) {
        node.right = start;
        node.left = null;
        if (start != null) start.left = node;
        start = node;
        if (end == null) end = start;
    }

    public void removeNode(EntryNode node) {

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

    private void printLRUCache(EntryNode entryNode) {
        while (entryNode != null) {
            System.out.print(entryNode.value + "->");
            entryNode = entryNode.right;
        }
        System.out.println("null");
    }

    static class EntryNode {
        int value;
        int key;
        EntryNode left;
        EntryNode right;
    }
}
