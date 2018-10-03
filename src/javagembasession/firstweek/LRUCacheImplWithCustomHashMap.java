package javagembasession.firstweek;

/******************************************************************************
 * Copyright (c) ::                                                           *
 * Creation Date - 11:9:2018,                                                 *
 * Created by - Rakesh Gupta,                                                 *
 * Package - javagembasession.firstweek.LRUCacheImplWithCustomHashMap                          *
 * Last modified - 9/11/18 2:45 PM                                            *
 * Project Name - DataStructureAlgorithm                                      *
 ******************************************************************************/

public class LRUCacheImplWithCustomHashMap {

    private HashMapCustom<Integer, EntryNode> mapImpl;

    private EntryNode start, end, head;

    // Size of LRU Cache.
    private static final int LRU_SIZE = 3;

    public LRUCacheImplWithCustomHashMap() {
        mapImpl = new HashMapCustom<>();
    }

    public static void main(String[] args) {

        LRUCacheImplWithCustomHashMap cache = new LRUCacheImplWithCustomHashMap();
        cache.putEntry(1, 1);
        cache.putEntry(10, 10);
        cache.putEntry(15, 15);
        cache.putEntry(55, 55);

        cache.printLRUCache(cache.start);

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

            // Decrease one for index and size sync.
            if (mapImpl.size() > (LRU_SIZE-1)) {
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
        if (head == null){
            head = start;
        }
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
        while (entryNode != null){
            System.out.print(entryNode.value+"->");
            entryNode = entryNode.right;
        }
        System.out.println("null");
    }

}
