package array.twopointer;

import java.util.ArrayList;

public class RemoveDuplicatesArray {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(0);
        list.add(1);
        list.add(2);
        list.add(2);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(5);
        System.out.println(removeDuplicates(list));
    }

    /**
     * Remove elements occurred more than two times
     * @param arrayList
     * @return
     */
    public static int removeDuplicates(ArrayList<Integer> arrayList) {
        if (arrayList.size() <= 1) return arrayList.size();
        int i = 1;
        int j = 1;
        boolean twice = false;
        while (i < arrayList.size()) {
            if (!arrayList.get(i).equals(arrayList.get(i - 1))) {
                arrayList.set(j, arrayList.get(i));
                j++;
                twice = false;
            } else {
                if (!twice) {
                    arrayList.set(j, arrayList.get(i));
                    twice = true;
                    j++;
                }
            }
            i++;
        }
        return j;
    }
}
