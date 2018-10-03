package javagembasession.secondweek;

/******************************************************************************
 * Copyright (c) ::                                                           *
 * Creation Date - 3:10:2018,                                                 *
 * Created by - Rakesh Gupta,                                                 *
 * Package - javagembasession.secondweek.FrequencyNode                        *
 * Last modified - 9/21/18 12:37 PM                                           *
 * Project Name - DataStructureAlgorithm                                      *
 ******************************************************************************/

class FrequencyNode extends Node {
    private int frequency;
    private NodeList cacheEntryList;

    public int getFrequency() {
        return frequency;
    }

    public NodeList getCacheEntryList() {
        return cacheEntryList;
    }

    public FrequencyNode(int frequency) {
        this.frequency = frequency;
        cacheEntryList = new NodeList();
    }
}
