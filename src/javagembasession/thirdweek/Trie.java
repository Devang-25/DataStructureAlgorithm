package javagembasession.thirdweek;

public class Trie {

    private static final int SIZE = 256;
    private static TrieNode root;

    public static void main(String[] args) {
        String keys[] = {"tree", "graph", "dynamic", "programming", "dynamic programming"};
        root = new TrieNode();
        for(String key : keys){
            insert(key);
        }

        if(search("programming"))
            System.out.println("programming --- found");
        else
            System.out.println("programming --- not found");


        if(search("test word"))
            System.out.println("test word --- found");
        else
            System.out.println("test word --- not found");

    }

    static class TrieNode {
        boolean isEndOfWord;
        TrieNode[] childs = new TrieNode[SIZE];

        TrieNode(){
            isEndOfWord = false;
            for (int i = 0; i < SIZE; i++)
                this.childs[i] = null;
        }
    }

    static void insert(String key) {
        int level;
        int length = key.length();
        int index;

        TrieNode pCrawl = root;

        for (level = 0; level < length; level++) {
            index = key.charAt(level);
            if (pCrawl.childs[index] == null)
                pCrawl.childs[index] = new TrieNode();

            pCrawl = pCrawl.childs[index];
        }

        pCrawl.isEndOfWord = true;
    }

    static boolean search(String key) {
        int level;
        int length = key.length();
        int index;
        TrieNode pCrawl = root;

        for (level = 0; level < length; level++) {
            index = key.charAt(level);

            if (pCrawl.childs[index] == null)
                return false;

            pCrawl = pCrawl.childs[index];
        }

        return (pCrawl != null && pCrawl.isEndOfWord);
    }
}

