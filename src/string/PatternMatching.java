package string;

public class PatternMatching {
    public static void main(String[] args) {
        int i = findOcc("mabcd", "a*c");
        System.out.println(i);
    }

    private static int findOcc(String str, String pattern) {
        for (char c : pattern.toCharArray()){
            int start = 0;
            while (true) {
                int idx = str.indexOf(start, c);
                if (idx != -1) {
                    if (matchPattern(idx, str, pattern)) {
                        return idx;
                    }else {
                        start = idx+1;
                    }
                }else {
                    continue;
                }
                break;
            }
        }
        return -1;
    }

    private static boolean matchPattern(int idx, String str, String pattern) {
        for (int i=0;i<pattern.length();i++){
            if (pattern.charAt(i) == str.charAt(idx+i) || pattern.charAt(i) == '*'){
                continue;
            }else {
                return false;
            }
        }
        return true;
    }
}
