package math;

import java.util.Collections;

public class AddBinaryString {

    public static void main(String[] args) {
        AddBinaryString addBinaryString = new AddBinaryString();
        String sum = addBinaryString.addBinary("01", "00");
        System.out.println(sum);
    }

    public String addBinary(String str1, String str2) {
        int maxLen = Math.max(str1.length(), str2.length());
        str1 = String.join("", Collections.nCopies(maxLen - str1.length(), "0")) + str1;
        str2 = String.join("", Collections.nCopies(maxLen - str2.length(), "0")) + str2;

        StringBuilder result = new StringBuilder();
        int carry = 0;
        for (int i = str1.length() - 1; i >= 0; i--) {
            int sum = Character.getNumericValue(str1.charAt(i)) + Character.getNumericValue(str2.charAt(i)) + carry;
            if (sum == 2) {
                result.append('0');
                carry = 1;
            } else if (sum == 3) {
                result.append('1');
                carry = 1;
            } else {
                result.append(sum);
                carry = 0;
            }
        }

        if (carry != 0)
            result.append(carry);

        return result.reverse().toString().replaceFirst("^0*", "");
    }

    public String addBinaryString(String a, String b) {
        int p1 = a.length() - 1;
        int p2 = b.length() - 1;
        StringBuilder buf = new StringBuilder();
        int carry = 0;
        while (p1 >= 0 || p2 >= 0) {
            int sum = carry;
            if (p1 >= 0) {
                sum += a.charAt(p1) - '0';
                p1--;
            }
            if (p2 >= 0) {
                sum += b.charAt(p2) - '0';
                p2--;
            }
            carry = sum >> 1;
            sum = sum & 1;
            buf.append(sum == 0 ? '0' : '1');
        }
        if (carry > 0) {
            buf.append('1');
        }
        buf.reverse();
        return buf.toString();
    }
}
