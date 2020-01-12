package math;

public class CompareTwoVersion {

    public static void main(String[] args) {
        System.out.println(compareVersion("1.1.1", "1.12.4"));
    }

    public static int compareVersion(String a, String b) {
        a = a.replaceFirst("^0*", "");
        b = b.replaceFirst("^0*", "");

        String[] strArrA = a.split("\\.");
        String[] strArrB = b.split("\\.");

        int length = Math.max(strArrA.length, strArrB.length);
        for (int i = 0; i < length; i++) {
            if (i < strArrA.length && i < strArrB.length) {
                if (strArrA[i].length() > strArrB[i].length()) return 1;
                else if (strArrA[i].length() < strArrB[i].length()) return -1;
            }
            Long n1 = i < strArrA.length ? Long.parseLong(strArrA[i]) : 0;
            Long n2 = i < strArrB.length ? Long.parseLong(strArrB[i]) : 0;

            int comp = n1.compareTo(n2);
            if (comp != 0) return comp;
        }
        return 0;
    }
}
