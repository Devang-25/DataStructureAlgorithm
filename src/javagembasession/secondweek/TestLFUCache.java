package javagembasession.secondweek;

/******************************************************************************
 * Copyright (c) ::                                                           *
 * Creation Date - 3:10:2018,                                                 *
 * Created by - Rakesh Gupta,                                                 *
 * Package - javagembasession.secondweek.TestLFUCache                         *
 * Last modified - 9/24/18 5:34 PM                                            *
 * Project Name - DataStructureAlgorithm                                      *
 ******************************************************************************/

public class TestLFUCache {
    public static void main(String args[]) {

        // Create LFU Cache with capacity - 5
        LFUCache<Integer, Integer> cache = new LFUCache<>(5);

        // Time complexity - O(1)
        cache.set(10, 13);
        cache.set(3, 17);
        cache.set(6, 11);
        cache.set(10, 5);

        // Time complexity - O(1)
        System.out.println(cache.get(10));
        cache.set(2, 19);
        System.out.println(cache.get(2));
        cache.set(1, 12);
        System.out.println(cache.get(10));
    }
}
 



