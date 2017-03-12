package geeksforgeeks.strings;

/**
 * Created by rakeshgupta on 11/1/16.
 */
public class LexicographicRankOfString {

   static int arr[] = new int[26];
    static int ans=0;
    public static void main(String[] args) {

        for (int i = 0; i < 26; i++) {
            arr[i] = 97+i;
        }
        String string = "string";
        int rank = rankString(string);
        if (rank==0)
            System.out.println(rank+1);
        else
            System.out.println(rank);
    }

    private static int rankString(String string) {
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            int temp = c-arr[i];
//            System.out.println(temp);
            if (temp<0)
                continue;
            ans = ans + temp*(string.length()-i);
        }
        return ans;
    }


}
