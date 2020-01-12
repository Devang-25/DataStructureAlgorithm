package math;

public class AtoiInJava {
    public static int atoi(final String str) {
        if (str.isEmpty()) return 0;
        String[] strArr = str.split("\\s+");
        boolean signFlg = true;
        if (!strArr[0].isEmpty() && strArr[0].charAt(0) == '-') {
            signFlg = false;
        }
        char[] numArr = strArr[0].toCharArray();
        StringBuilder sb = new StringBuilder("");
        int firstChar = 0;

        for (char num : numArr) {
            if (Character.isDigit(num)) {
                firstChar = 1;
                sb.append(num);
            } else if (firstChar == 0 && (num == '+' || num == '-')) {
                firstChar = 1;
                continue;
            } else {
                break;
            }
        }

        if (sb.length() == 0) return 0;
        int ans = 0;
        try {
            ans = Integer.parseInt(sb.toString());
            ans *= signFlg == true ? 1 : -1;
        } catch (Exception e) {
            if (signFlg) {
                ans = Integer.MAX_VALUE;
            } else {
                ans = Integer.MIN_VALUE;
            }
        }
        return ans;
    }
}
