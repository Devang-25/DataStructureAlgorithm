package tddtraining;

public class CalculateString {

    public int sum(String str) {
        int num = 0;

        if (isNotNullOrEmpty(str)) {
            String[] strArr = str.split("[, \n]");
            for (String s : strArr) {
                if (isValidStr(s)) {
                    num += Integer.parseInt(s);
                }
            }
        }
        return num;
    }

    private boolean isNotNullOrEmpty(String str) {
        return (str != null && str != "");
    }

    private boolean isValidStr(String str) {
        return isNotNullOrEmpty(str) && isNotNegative(str.trim());
    }

    private boolean isNotNegative(String str) {
        if (Integer.parseInt(str) > -1)
            return true;
        throw new NumberFormatException("Negative number not allowed!!");
    }
}
