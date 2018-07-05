package arithmetic;

import java.util.ArrayList;

/******************************************************************************
 * Copyright (c) ::                                                           *
 * Creation Date - 5:7:2018,                                                  *
 * Created by - Rakesh Gupta,                                                 *
 * Package - arithmetic.ObjectCounter                                         *
 * Last modified - 7/5/18 1:47 PM                                             *
 * Project Name - DataStructureAlgorithm                                      *
 ******************************************************************************/

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
