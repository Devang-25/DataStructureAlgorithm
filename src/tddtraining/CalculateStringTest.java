package tddtraining;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculateStringTest {

    private CalculateString calculateString;

    @Before
    public void setUp() {
        calculateString = new CalculateString();
    }

    @Test
    public void shouldReturnZero() {
        CalculateString calculateString = new CalculateString();
        Assert.assertEquals(0, calculateString.sum(""));
    }

    @Test
    public void shouldReturnOne() {
        CalculateString calculateString = new CalculateString();
        Assert.assertEquals(1, calculateString.sum("1"));
    }

    @Test
    public void shouldReturnTwo() {
        CalculateString calculateString = new CalculateString();
        Assert.assertEquals(2, calculateString.sum("1,1"));
    }

    @Test(expected = NumberFormatException.class)
    public void shouldThrowNegativeException() {
        CalculateString calculateString = new CalculateString();
        Assert.assertEquals(2, calculateString.sum("1,-1,1"));
    }

}
