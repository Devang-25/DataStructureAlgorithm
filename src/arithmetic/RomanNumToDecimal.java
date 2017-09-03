package arithmetic;

/**
 * Created by : Rakesh Gupta on 9/4/17
 * Package : arithmetic
 */
public class RomanNumToDecimal {

    public static void main(String[] args) {
        java.util.HashMap<Character, Integer> romanToDecimal = new java.util.HashMap<>();

        romanToDecimal.put('I', 1);
        romanToDecimal.put('V', 5);
        romanToDecimal.put('X', 10);
        romanToDecimal.put('L', 50);
        romanToDecimal.put('C', 100);
        romanToDecimal.put('D', 500);
        romanToDecimal.put('M', 1000);


        java.util.Scanner scanner = new java.util.Scanner(System.in);
        String roman = scanner.nextLine();
        char[] romanArray = roman.toCharArray();

        int sum = 0;

        for (int i = 0; i < romanArray.length; i++) {
            char ch = romanArray[i];
            if ((i+1)< romanArray.length){
                if (romanToDecimal.get(ch) < romanToDecimal.get(romanArray[i+1])) {
                    sum += (romanToDecimal.get(romanArray[i + 1]) - romanToDecimal.get(ch));
                    i++;
                }else {
                    sum += romanToDecimal.get(ch);
                }
            }else {
                sum += romanToDecimal.get(ch);
            }
        }

        System.out.println(sum);

    }
}
