package arithmetic;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by rakeshgupta on 7/16/17.
 */

public class ObjectCounter {
    public static void addObjectsToListAndPrintCount(ArrayList<AngryNerds> list, int n) {
        for(int i = 0; i < n; i++) {
            list.add(AngryNerds.getInstance());
        }
        if(list.size() > 0) {
            AngryNerds a = list.get(0);
            System.out.println(a.getCount());
        } else {
            System.out.println(0);
        }
    }

}

class AngryNerds {
    private static int count;
    public AngryNerds() {
        count++;
    }
    public static AngryNerds getInstance() {
        return new AngryNerds();
    }
    public Integer getCount() {
        return count;
    }

    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<AngryNerds> ls = new ArrayList<AngryNerds>();
        ObjectCounter.addObjectsToListAndPrintCount(ls, n);
    }
}
