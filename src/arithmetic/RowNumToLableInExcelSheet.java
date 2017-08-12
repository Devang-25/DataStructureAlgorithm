package arithmetic;

/**
 * Created by : Rakesh Gupta on 8/13/17
 * Package : arithmetic
 */
public class RowNumToLableInExcelSheet {

    public static void main(String[] args) {

        int num = 701;
        String str = getLableFromRowNum(num);
        System.out.println("Row number :" + num + " to excel sheet label is : " + str);

        str = "AAA";
        double newNum = getRowNumFromLable(str);
        System.out.println("String : " + str + " to excel sheet row number is : " + newNum);
    }

    private static double getRowNumFromLable(String str) {

        double sum = 0;
        int index = 0;

        for (int i = str.length()-1; i >=0 ; i--) {
            //base10val+previousRowNum
            sum += (str.charAt(i) - 'A')*Math.pow(26, index)+Math.pow(26, i);
            index++;
        }
        return sum-1;
    }

    private static String getLableFromRowNum(int num) {


        return null;
    }
}
