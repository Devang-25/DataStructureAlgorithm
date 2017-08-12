package array;

import java.util.Arrays;

/**
 * Created by : Rakesh Gupta on 8/12/17
 * Package : array
 */
public class SumEqualToSubSet {
    public static void main(String[] args) {
        int menu[] = new int[]{2, 7, 4, 13, 13, 5, 5};
        int money = 10;
        int[] items  = findChoices(menu, money);
        System.out.print("Finding the indices of two items on the menu that allow to spend all your money : ");
        for (int i = 0; i < items.length; i++) {
            System.out.print( menu[i] + " ");
        }
    }

    private static int[] findChoices(int[] menu, int money) {
        int[] sortedMenu = menu.clone();
        Arrays.sort(sortedMenu);

        for (int i = 0; i < sortedMenu.length; i++) {

            int complement = money - sortedMenu[i];

            int location = Arrays.binarySearch(sortedMenu, i+1, sortedMenu.length, complement);

            if (location >= 0 && location < sortedMenu.length && sortedMenu[location] == complement){
                int[] indices = getIndicesFromValues(menu, sortedMenu[i], complement);
                return indices;
            }
        }
        return null;
    }

    private static int[] getIndicesFromValues(int[] menu, int value1, int value2) {
        int index1 = getIndexOf(menu, value1, -1);
        int index2 =  getIndexOf(menu, value2, index1);
        int[] indices = {Math.min(index1, index2), Math.max(index1, index2)};
        return indices;
    }

    private static int getIndexOf(int[] menu, int value, int exclude) {

        for (int i = 0; i < menu.length; i++) {
            if (menu[i] == value && i != exclude)
                return i;
        }
        return -1;
    }
}
