package dsaonlinegeeksforgeeks;

public class BinaryNumConversion {
    public static void main(String[] args) {
        solution(new int[]{1, 0, 0, 1, 1});
        //solution(new int[]{0,0,1,0,1,1});
        String arr = "11";

    }

    public static int[] solution(int[] arr) {
        if (arr.length == 0)
            return new int[]{0};

        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] * Math.pow(-2, i);
        }
        int n = (int) Math.ceil(sum / 2);
        if (n > 0) {
            return numToArr(n);
        }
        return null;
    }

    public static int[] numToArr(int n) {
        String numStr = Integer.toBinaryString(n);
        int arr[] = new int[numStr.length()];
        for(int i = 0; i < numStr.length(); i++) {
            arr[i] = numStr.charAt(i);
        }
        return arr;
    }
}
