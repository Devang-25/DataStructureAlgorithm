package tddtraining;

public class FizzBuzzSolution {

    private static final String FIZZ = "Fizz";
    private static final String BUZZ = "Buzz";
    private static final String FIZZBUZZ = "FizzBuzz";

    private static final int FIZZ_NUM = 3;
    private static final int BUZZ_NUM = 5;

    public String getFizzBuzzString(int num) {
        String fizzBuzzStr = getFizzOrBuzz(num);
        return fizzBuzzStr != null ? fizzBuzzStr : String.valueOf(num);
    }

    private String getFizzOrBuzz(int num) {
        String fizzBuzzStr = null;
        if (isDivisibleByThreeAndFive(num)) {
            fizzBuzzStr = FIZZBUZZ;
        } else if (isDivisibleByNum(num, FIZZ_NUM)) {
            fizzBuzzStr = FIZZ;
        } else if (isDivisibleByNum(num, BUZZ_NUM)) {
            fizzBuzzStr = BUZZ;
        }
        return fizzBuzzStr;
    }

    private boolean isDivisibleByNum(int num, int divisor) {
        return num % divisor == 0;
    }

    private boolean isDivisibleByThreeAndFive(int num) {
        return isDivisibleByNum(num, FIZZ_NUM) && isDivisibleByNum(num, BUZZ_NUM);
    }
}
