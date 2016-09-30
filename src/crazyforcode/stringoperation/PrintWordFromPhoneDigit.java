package crazyforcode.stringoperation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rakeshgupta on 9/29/16.
 */
public class PrintWordFromPhoneDigit {

    private List<String> strs = new ArrayList<>();
    private int depth = 0;
    char[] numbersArray;

    public static void main(String[] args) {

        PrintWordFromPhoneDigit obj = new PrintWordFromPhoneDigit();
        obj.PrintLetters("234");
        System.out.println(obj.strs);
        System.out.println(obj.depth);
    }

    private void PrintLetters(String numbers)
    {

        this.numbersArray = numbers.toCharArray();
        this.PrintAllCombinations(this.GetCharacters(this.numbersArray[0]), "");
    }

    private void PrintAllCombinations(char[] letters, String output)
    {
        depth++;
        for (int i = 0; i < letters.length; i++)
        {

            if (this.depth != 3)
            {
                output += letters[i];
                this.PrintAllCombinations(this.GetCharacters(
                        this.numbersArray[depth]), output);
            }
            else
            {
                this.strs.add(output + letters[i]);
            }
        }
    }


    private char[] GetCharacters(char x)
    {
        char[] arr;
        switch (x)
        {
            case '0':
            {
                arr = new char[]{'0'};
                return arr;
            }

            case '1': arr = new char[] { '1' };
            return arr;
            case '2': arr = new char[] { 'a', 'b', 'c' };
            return arr;
            case '3': arr = new char[] { 'd', 'e', 'f' };
            return arr;
            case '4': arr = new char[] { 'g', 'h', 'i' };
            return arr;
            case '5': arr = new char[] { 'j', 'k', 'l' };
            return arr;
            case '6': arr = new char[] { 'm', 'n', 'o' };
            return arr;
            case '7': arr = new char[] { 'p', 'q', 'r', 's' };
            return arr;
            case '8': arr = new char[] { 't', 'u', 'v' };
            return arr;
            case '9': arr = new char[] { 'w', 'x', 'y', 'z' };
            return arr;
            default: return null;
        }
    }


}
