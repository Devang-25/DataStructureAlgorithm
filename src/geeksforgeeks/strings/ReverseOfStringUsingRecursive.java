package geeksforgeeks.strings;

/**
 * Created by rakeshgupta on 11/1/16.
 */
public class ReverseOfStringUsingRecursive {
    public static void main(String[] args) {
        String str = "abcdefghi";
        String ans = reverse(str);
        System.out.println(ans);
    }

    private static String reverse(String str) {
        if (str.length() <= 1)
            return str;
        else
            return str.charAt(str.length()-1)+reverse(str.substring(0,str.length()-1));
    }


}
