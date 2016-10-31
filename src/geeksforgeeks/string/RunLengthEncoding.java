package geeksforgeeks.string;

/**
 * Created by rakeshgupta on 11/1/16.
 */
public class RunLengthEncoding {
    public static void main(String[] args) {
        String str = "wwwwaadddmmm";
        StringBuffer sb = new StringBuffer();
        lengthEncoding(str, sb);
        System.out.println(sb.toString());
    }

    private static void lengthEncoding(String str, StringBuffer sb) {
        char last = ' ';
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int num = 1;
            if (c != last) {
                num = str.length() - (str.replaceAll("" + c, "").length());
                sb.append(c);
                sb.append(num);
            }
            last = c;
        }
    }
}
