package techdevguidegoogleadvance;

import helperutil.InputReader;

public class StringDecompression {
    public static void main(String[] args) {
        InputReader inputReader = new InputReader();
        String input = inputReader.nextLine();

        String[] arr = input.split("\\d+");
        print(arr);
//        for (char c: input.toCharArray()){
//
//        }
    }
    private static void print(String[] arr){
        for(String  s:arr){
            System.out.print(s+" ");
        }
    }

    private static int findCountFromString(String str){
        String numStr = str.substring(0, str.indexOf('['));
        return Integer.parseInt(numStr);
    }

    private static void printStringWithCount(int c, String str){
        for (int i=0;i<c;i++){
            System.out.print(str);
        }
    }
}
