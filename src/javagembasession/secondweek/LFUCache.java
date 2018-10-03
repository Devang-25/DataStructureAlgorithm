package javagembasession.secondweek;

import java.util.HashMap;

/******************************************************************************
 * Copyright (c) ::                                                           *
 * Creation Date - 3:10:2018,                                                 *
 * Created by - Rakesh Gupta,                                                 *
 * Package - javagembasession.secondweek.LFUCache                             *
 * Last modified - 9/21/18 12:37 PM                                           *
 * Project Name - DataStructureAlgorithm                                      *
 ******************************************************************************/
public class LFUCache<K, V> {

    HashMap<K, LFUCacheEntry<K, V>> kvStore;
    NodeList freqList;
    HashMap<Integer, FrequencyNode> frequencyMap;
    int capacity;
    int size;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        kvStore = new HashMap<>();
        freqList = new NodeList();
        frequencyMap = new HashMap<>();
    }

    public void delete(LFUCacheEntry<K, V> entry) {
        if (!kvStore.containsKey(entry.getKey()))
            return;

        kvStore.remove(entry.getKey());
        entry.getFrequencyNode().getCacheEntryList().remove(entry);
        if (entry.getFrequencyNode().getCacheEntryList().length <= 0) {
            frequencyMap.remove(entry.getFrequencyNode().getFrequency());
            freqList.remove(entry.getFrequencyNode());
        }
        size--;
    }


    public FrequencyNode getFrequencyNode(int frequency) {
        if (!frequencyMap.containsKey(frequency - 1) &&
                !frequencyMap.containsKey(frequency) &&
                frequency != 1) {
            return null;
        }

        if (!frequencyMap.containsKey(frequency)) {
            FrequencyNode newFrequencyNode = new FrequencyNode(frequency);
            if (frequency != 1)
                freqList.insertAfter(frequencyMap.get(frequency - 1),
                        newFrequencyNode);
            else
                freqList.prepend(newFrequencyNode);
            frequencyMap.put(frequency, newFrequencyNode);
        }

        return frequencyMap.get(frequency);
    }

    public void set(K key, V value) {
        if (capacity == 0)
            return;
        FrequencyNode newFrequencyNode = null;
        if (kvStore.containsKey(key)) {
            newFrequencyNode = getFrequencyNode(kvStore.get(key).getFrequencyNode().getFrequency() + 1);
            delete(kvStore.get(key));
        } else if (size == capacity) {
            FrequencyNode fNode = (FrequencyNode) freqList.head;
            LFUCacheEntry<K, V> entry = (LFUCacheEntry<K, V>) fNode.getCacheEntryList().head;
            delete(entry);
        }
        if (newFrequencyNode == null)
            newFrequencyNode = getFrequencyNode(1);
        LFUCacheEntry<K, V> entry = new LFUCacheEntry<>(key, value,
                newFrequencyNode);
        kvStore.put(key, entry);
        newFrequencyNode.getCacheEntryList().append(entry);
        size++;
    }


    public V get(K key) {
        if (!kvStore.containsKey(key) || capacity == 0)
            return null;

        LFUCacheEntry<K, V> entry = kvStore.get(key);
        FrequencyNode newFrequencyNode =
                getFrequencyNode(entry.getFrequencyNode().getFrequency() + 1);
        entry.getFrequencyNode().getCacheEntryList().remove(entry);
        newFrequencyNode.getCacheEntryList().append(entry);
        if (entry.getFrequencyNode().getCacheEntryList().length <= 0) {
            frequencyMap.remove(entry.getFrequencyNode().getFrequency());
            freqList.remove(entry.getFrequencyNode());
        }
        entry.setFrequencyNode(newFrequencyNode);
        return entry.getValue();
    }
}





