package sample_exercise.dictionary;

import java.util.HashMap;

/**
 * Created by rakeshgupta on 3/24/17.
 */
public class ValidSentenceCreator {
    public static void main(String[] args) {
//        String abc[] = new String[20];
//        abc[0] = "Google";
//        abc[1] = "big";
//        abc[2] = "is";
//        abc[3] = "company";
//        abc[4] = "shopping";
        String garr[] = {"Google", "good", "god"};
        String iarr[] = {"is"};
        String carr[] = {"company"};
        String barr[] = {"big"};
        String sarr[] = {"shopping"};
        String earr[] = {"ecommece"};

        String input = "googleisbigcompany";
        char abc[] = input.toCharArray();

        HashMap<String, String[]> set = new HashMap<>();
        set.put("g", garr);
        set.put("i", iarr);
        set.put("c", carr);
        set.put("s", sarr);
        set.put("e", earr);
        set.put("b", barr);


        for (char s : abc) {
            String arr[] = set.get(s);
            System.out.println(arr);
            for (String s2 : arr){
                CharSequence ss = s2;
                if (input.contains(ss)) {
                    CharSequence sss = ss.toString()+ " ";
                    input = input.replace(ss, sss);
                }
            }
        }

        System.out.println(input);
    }

}
