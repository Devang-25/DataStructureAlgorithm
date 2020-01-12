package math;

public class ExcelColumnNumber {

    public static void main(String[] args) {
        System.out.println(new ExcelColumnNumber().titleToNumber("A23"));
    }

    public int titleToNumber(String A) {
        int col = 0;
        int pow = A.length() - 1;

        for (int i = 0; i < A.length(); i++) {
            if (i == A.length() - 1) {
                col += (int) A.charAt(i) - 65 + 1;
            } else {
                col += (Math.pow(26, pow)) * ((int) A.charAt(i) - 65 + 1);
            }
            pow--;
        }
        return col;
    }
}
