package javagembasession.thirdweek;

public class DictionaryUsingTrie {

    /**
     * If space not allowed in word then - SIZE = 26
     *                         otherwize - SIZE = 256
     */
    private static final int ALPHABET_SIZE = 256;
    private static Node root;

    public static void main(String[] args) {
        String keys[] = {"tree", "graph", "dynamic", "programming",
                "dynamic programming"};
        root = new Node();
        for(String key : keys){
            addWord(key);
        }

        if(searchWord("programming"))
            System.out.println("programming --- found");
        else
            System.out.println("programming --- not found");

        if(searchWord("dynamic programming"))
            System.out.println("dynamic programming --- found");
        else
            System.out.println("dynamic programming --- not found");


        if(searchWord("test word"))
            System.out.println("test word --- found");
        else
            System.out.println("test word --- not found");
    }

    static class Node {
        boolean isWord;
        Node[] children = new Node[ALPHABET_SIZE];

        Node(){
            isWord = false;
            for (int i = 0; i < ALPHABET_SIZE; i++)
                this.children[i] = null;
        }
    }

    /**
     *  Time complexity - O(Len(key))
     * @param key
     */
    static void addWord(String key) {
        int level;
        int length = key.length();
        int index;

        Node currNode = root;

        for (level = 0; level < length; level++) {
            index = key.charAt(level);
            if (currNode.children[index] == null)
                currNode.children[index] = new Node();

            currNode = currNode.children[index];
        }

        currNode.isWord = true;
    }

    /**
     * Time complexity - O(Len(key))
     * @param key
     * @return
     */
    static boolean searchWord(String key) {
        int level;
        int length = key.length();
        int index;
        Node currNode = root;

        for (level = 0; level < length; level++) {
            index = key.charAt(level);

            if (currNode.children[index] == null)
                return false;

            currNode = currNode.children[index];
        }

        return (currNode != null && currNode.isWord);
    }
}
