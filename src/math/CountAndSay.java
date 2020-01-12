package math;

public class CountAndSay {

    public static void main(String[] args) {
        System.out.println("test");
        String ans = countAndSay(4);
        System.out.println(ans);
    }

    public static String countAndSay(int num) {
        if (num == 0) {
            return "";
        }
        StringBuilder numCountStr = new StringBuilder();
        String ans = "1";
        int countNum;
        while (num > 1) {
            countNum = 1;
            for (int i = 0; i < ans.length() - 1; i++) {
                if (ans.charAt(i) == ans.charAt(i + 1)) {
                    countNum++;
                } else {
                    numCountStr.append(countNum).append(ans.charAt(i));
                    countNum = 1;
                }
            }

            if (countNum > 1) {
                numCountStr.append(countNum).append(ans.charAt(ans.length() - 1));
            } else {
                numCountStr.append("1").append(ans.charAt(ans.length() - 1));
            }

            ans = numCountStr.toString();
            numCountStr.setLength(0);
            num--;
        }
        return ans;
    }
}
