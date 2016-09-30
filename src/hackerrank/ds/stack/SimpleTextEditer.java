package hackerrank.ds.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by rakeshgupta on 9/25/16.
 */
public class SimpleTextEditer {
    
    public static void main(String[] args) {

        Stack stack = new Stack();
        StringBuffer stringBuffer = new StringBuffer();
        StringBuffer temp = new StringBuffer();
        Scanner scanner = new Scanner(System.in);
        int q = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < q; i++) {
            String append = null;
            int delNo = -1, printChar = -1;

            String s = scanner.nextLine();

            int command = Integer.parseInt(s.split(" ")[0]);

            if (command == 1)
                append = s.split(" ")[1];
            if (command == 2)
                delNo = Integer.parseInt(s.split(" ")[1]);
            if (command == 3)
                printChar = Integer.parseInt(s.split(" ")[1]);

            if(append !=null) {
                stack.push(stringBuffer);
                stringBuffer.append(append);
            }
            if (delNo != -1) {
                stack.push(stringBuffer);
                stringBuffer = stringBuffer.replace(stringBuffer.length() - delNo, stringBuffer.length(), "");
            }
            if(printChar != -1)
                System.out.println(stringBuffer.charAt(printChar-1));
            if (command ==4 ){
                stringBuffer = ((StringBuffer) stack.pop());
            }




        }
    }
}
