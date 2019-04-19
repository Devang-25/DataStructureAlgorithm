package tddtraining;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Random;

public class FizzBuzzSolutionTest {

    private FizzBuzzSolution fizzBuzzSolution;

    @Before
    public void setUp() {
        fizzBuzzSolution = new FizzBuzzSolution();
    }

    @Test
    public void shouldReturnOne() {
        Assert.assertEquals("1", fizzBuzzSolution.getFizzBuzzString(1));
    }

    @Test
    public void shouldReturnTwo() {
        Assert.assertEquals("2", fizzBuzzSolution.getFizzBuzzString(2));
    }

    @Test
    public void shouldReturnFizz() {
        Assert.assertEquals("Fizz", fizzBuzzSolution.getFizzBuzzString(3));
    }

    @Test
    public void shouldReturnFour() {
        Assert.assertEquals("4", fizzBuzzSolution.getFizzBuzzString(4));
    }

    @Test
    public void shouldReturnBuzz() {
        Assert.assertEquals("Buzz", fizzBuzzSolution.getFizzBuzzString(5));
    }

    @Ignore
    @Test
    public void shouldReturnSameNum() {
        int randomNum = getRandomNumNotDivisibleByThreeAndFive();
        Assert.assertEquals(randomNum, fizzBuzzSolution.getFizzBuzzString(randomNum));
    }

    private int getRandomNumNotDivisibleByThreeAndFive() {
        Random random = new Random();
        int randomNum = random.nextInt(100);
        while (randomNum % 3 != 0 && randomNum % 5 != 0) {
            randomNum = random.nextInt(100);
        }
        return randomNum;
    }

    @Test
    public void shouldReturnFizzBuzz() {
        Assert.assertEquals("FizzBuzz", fizzBuzzSolution.getFizzBuzzString(15));
    }

    @Test
    public void shouldReturnFizzBuzzForBigNum() {
        Assert.assertEquals("FizzBuzz", fizzBuzzSolution.getFizzBuzzString(3 * 5 * 3 * 5 * 5 * 5));
    }
}