package geeksforgeeks.string;

/**
 * Created by rakeshgupta on 11/1/16.
 */
public class PrintAllPermutation {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("abcde");
        PrintAllPermutation printAllPermutation = new PrintAllPermutation();
        printAllPermutation.doPermutation(sb, sb.length());
    }

    public void doPermutation(StringBuffer str, int index){
        if (index <= 0) {
            System.out.printf(str.toString());
            System.out.print(" ");
        }
        else {
            doPermutation(str, index-1);
            int currPos = str.length()-index;

            for (int i = currPos+1; i <str.length(); i++) {
                swap(str, currPos, i);
                doPermutation(str, index-i);
                swap(str, i, currPos);
            }
        }
    }

    private void swap(StringBuffer str, int pos1, int pos2) {
        char t1 = str.charAt(pos1);
        str.setCharAt(pos1, str.charAt(pos2));
        str.setCharAt(pos2, t1);
    }
}
