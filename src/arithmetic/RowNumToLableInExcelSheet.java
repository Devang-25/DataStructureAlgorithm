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
        System.out.println("String : " + str + " to excel sheet row number is : " + ((int) newNum));
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

        String ans = "";
        ans += (char)('A' + (num%26));
        num = num/26;
        while (num>0){
            ans = (char)('A' + ((num-1)%26))+ans;
            num = (num-1)/26;
        }

        return ans;
    }
}
