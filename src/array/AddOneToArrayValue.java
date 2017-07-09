package array;

/**
 * Created by rakeshgupta on 4/3/17.
 */
public class AddOneToArrayValue {
    public static void main(String[] args) {
        int arr[] = {9,9,9};
        int newArr[] = new int[arr.length+1];
        String s = "";

        System.out.print("Before Adding : ");
        for (int g : arr)
            System.out.print(g);
        System.out.println();

        for (int a : arr){
            s = s + a;
        }
        int c = Integer.parseInt(s) + 1;
        String ss = new String(c+"");

        char abc[] = ss.toCharArray();
        int n = 0;
        for (char m : abc){
            newArr[n] = Character.getNumericValue(m);
            n++;
        }

        System.out.print("After Adding : ");
        for (int g : newArr)
            System.out.print(g);
    }

}
