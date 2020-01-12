package math;

public class ValidNumber {
    public static void main(String[] args) {

    }

    public int isNumber(final String A) {
        char[] charArray = A.toCharArray();
        int decCount = 0;
        int digCount = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (Character.isDigit(charArray[i])) {
                digCount++;
                continue;
            } else if (charArray[i] == '+' || charArray[i] == '-') {
                if (i == 0) {
                    continue;
                }
                if (charArray[i - 1] != 'e') {
                    return 0;
                }
            } else if (charArray[i] == ' ') {
                continue;
            } else if (charArray[i] == '.') {
                decCount++;
                if (decCount > 1) return 0;
                if (i == charArray.length - 1) return 0;
            } else if (charArray[i] == 'e') {
                if (i + 2 >= charArray.length) return 0;
                try {
                    if (A.substring(i + 1).indexOf('.') != -1) return 0;
                    Integer.parseInt(A.substring(i + 1));
                } catch (Exception e) {
                    return 0;
                }
            } else {
                return 0;
            }
        }
        return digCount > 0 ? 1 : 0;
    }
}
