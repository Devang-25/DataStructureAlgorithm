package tddtraining;

import java.util.Collections;
import java.util.Map;

public class MaximizeBookDiscount {

    private static final int SINGLE_BOOK_PRICE = 8;

    public double getDiscountedTotalSum(Map<String, Integer> map) {
        double totalSum = 0;
        int bookSize = map.keySet().size();
        while (bookSize > 0) {
            int discountSet = Collections.min(map.values());
            totalSum += getBookPriceAfterDiscount(bookSize, discountSet);
            this.removeBilledBook(map, discountSet);
            bookSize = map.keySet().size();
        }
        return totalSum;
    }

    private double getBookPriceAfterDiscount(int bookSize, int discountSet) {
        return discountSet * bookSize * SINGLE_BOOK_PRICE * getDiscountPercentage(bookSize);
    }

    private double getDiscountPercentage(int bookSize) {
        return 1d - (getDiscount(bookSize) / 100d);
    }

    private void removeBilledBook(Map<String, Integer> inputMap, int minLengthBookSize) {
        inputMap.replaceAll((k, v) -> v - minLengthBookSize);
        inputMap.entrySet().removeIf(entry -> entry.getValue() == 0);
    }

    private int getDiscount(int bookSize) {
        int discount = 0;
        switch (bookSize) {
            case 1:
                discount = 0;
                break;
            case 2:
                discount = 5;
                break;
            case 3:
                discount = 10;
                break;
            case 4:
                discount = 20;
                break;
            case 5:
                discount = 25;
                break;
        }
        return discount;
    }
}
