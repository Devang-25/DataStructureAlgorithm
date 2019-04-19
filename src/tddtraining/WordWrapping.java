package tddtraining;

public class WordWrapping {

    public String format(String sentence, int limit) {
        StringBuffer formattedSentence = new StringBuffer();
        int currRemainingSpace = limit;
        int it = 0;
        boolean lastWordIsNewLine = false;
        while (true) {
            if (it > sentence.split(" ").length - 1) {
                return formattedSentence.toString().trim();
            }
            String word = findNextWord(sentence, it);
            if (isNotNullOrEmpty(word)) {
                if (word.length() <= currRemainingSpace) {
                    if (word.length() != limit && currRemainingSpace < limit) {
                        formattedSentence.append(" ");
                    }
                    formattedSentence.append(word);
                    currRemainingSpace = currRemainingSpace - word.length();
                    it++;
                    continue;
                } else {
                    formattedSentence.append("\n");
                    lastWordIsNewLine = true;
                }
                if (word.length() > limit) {
                    currRemainingSpace = addNewLineInWord(formattedSentence, word, limit, currRemainingSpace);
                } else {
                    if (!lastWordIsNewLine) {
                        formattedSentence.append("\n");
                    }
                    formattedSentence.append(word);
                }
                it++;
            }
        }
    }

    private String findNextWord(String sentence, int i) {
        return sentence.split(" ")[i];
    }

    private int addNewLineInWord(StringBuffer formattedSentence, String word, int limit, int currRemainingSpace) {
        int sentenceLength = word.length();
        int currPointer = 0;
        while (sentenceLength - currPointer > limit) {
            formattedSentence.append(word.substring(currPointer, currPointer + limit));
            formattedSentence.append("\n");
            currPointer = currPointer + limit;
        }
        String lastWord = word.substring(currPointer, sentenceLength);
        formattedSentence.append(lastWord);
        return (sentenceLength - currPointer - lastWord.length());
    }

    private boolean isNotNullOrEmpty(String str) {
        return (str != null && str != "");
    }

    public String wrap(String s, int l) {
        int lineBreak = getLineBreak(s, l);
        if (s.length() > l) {
            return s.substring(0, lineBreak).trim() + "\n" + wrap(s.substring(lineBreak, s.length()).trim(), l);
        }
        return s;
    }

    private int getLineBreak(String s, int l) {
        int lineBreak = s.lastIndexOf(" ", l);
        if (lineBreak == -1)
            return l;
        return lineBreak;
    }
}
