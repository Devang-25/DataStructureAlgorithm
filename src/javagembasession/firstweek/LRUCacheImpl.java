package javagembasession.firstweek;

/******************************************************************************
 * Copyright (c) ::                                                           *
 * Creation Date - 11:9:2018,                                                 *
 * Created by - Rakesh Gupta,                                                 *
 * Package - javagembasession.firstweek.LRUCacheImpl                          *
 * Last modified - 9/11/18 2:45 PM                                            *
 * Project Name - DataStructureAlgorithm                                      *
 ******************************************************************************/

public class LRUCacheImpl {

    private HashMapCustom<Integer, EntryNode> mapImpl;

    private EntryNode start, end;

    // Size of LRU Cache.
    private static final int LRU_SIZE = 4;

    public LRUCacheImpl() {
        mapImpl = new HashMapCustom<>();
    }

    public static void main(String[] args) {

        LRUCacheImpl cache = new LRUCacheImpl();
        cache.putEntry(1, 1);
        cache.putEntry(10, 15);
        cache.putEntry(15, 10);
        cache.putEntry(10, 16);
        cache.putEntry(12, 15);
        cache.putEntry(18, 10);
        cache.putEntry(13, 16);

        System.out.println(cache.getEntry(1));
        System.out.println(cache.getEntry(10));
        System.out.println(cache.getEntry(15));

    }

    public int getEntry(int key) {

        if (mapImpl.get(key) != null) {
            EntryNode entry = mapImpl.get(key);
            removeNode(entry);
            addAtTop(entry);
            return entry.value;
        }
        // If no key is found then return -1.
        return -1;
    }

    public void putEntry(int key, int value) {

        if (mapImpl.get(key) != null) {
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

            if (mapImpl.size() > LRU_SIZE) {
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
        if (start != null)
            start.left = node;
        start = node;
        if (end == null)
            end = start;
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

}
