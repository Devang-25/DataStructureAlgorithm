package geeksforgeeks.strings;

/**
 * Created by rakeshgupta on 11/1/16.
 */
public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String str = "geeksforgeeksfo";
        FirstNonRepeatingCharacter obj = new FirstNonRepeatingCharacter();
        System.out.println(obj.findChar(str));
    }

    private String findChar(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (checkFrequency(c,str)==1)
                return "found: "+c;
            else {
                if (i == str.length()-1)
                return "not found";
            }
        }
        return "not found";
    }

    private static int checkFrequency(char c, String str) {
        int length = str.length() - ( str.replaceAll(""+c,"").length());
        if (length==1)
            return 1;
        else
            return 0;
    }

}
