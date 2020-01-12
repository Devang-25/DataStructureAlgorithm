package string;

import java.util.ArrayList;

public class LongestCommonPrefix {
    public static void main(String[] args) {

    }

    public String longestCommonPrefix(ArrayList<String> list) {
        list.sort((s1, s2) -> s1.length() - s2.length());
        String word = list.get(0);
        return getMaxLengthWord(word, list);
    }

    public String getMaxLengthWord(String shortWord, ArrayList<String> list) {
        while (!shortWord.isEmpty()) {
            boolean flag = true;
            for (String word : list) {
                if (!word.startsWith(shortWord)) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                break;
            shortWord = shortWord.substring(0, shortWord.length() - 1);
        }
        return shortWord;
    }
}
