package tddtraining;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class MaximizeBookDiscountTest {

    private MaximizeBookDiscount maximizeBookDiscount;

    @Before
    public void setUp() {
        maximizeBookDiscount = new MaximizeBookDiscount();
    }

    @Test
    public void shouldGiveForBookA() {
        Map<String, Integer> input = new HashMap<String, Integer>() {{
            put("A", 1);
        }};
        Assert.assertEquals(8d, maximizeBookDiscount.getDiscountedTotalSum(input), .0d);
    }

    @Test
    public void shouldGiveForBookB() {
        Map<String, Integer> input = new HashMap<String, Integer>() {{
            put("B", 1);
        }};
        Assert.assertEquals(8d, maximizeBookDiscount.getDiscountedTotalSum(input), .0d);
    }

    @Test
    public void shouldGiveForBookAB() {
        Map<String, Integer> input = new HashMap<String, Integer>() {{
            put("A", 1);
            put("B", 1);
        }};
        Assert.assertEquals(15.2d, maximizeBookDiscount.getDiscountedTotalSum(input), .0d);
    }

    @Test
    public void shouldGiveForBookABC() {
        Map<String, Integer> input = new HashMap<String, Integer>() {{
            put("A", 1);
            put("B", 1);
            put("C", 1);
        }};
        Assert.assertEquals(21.6d, maximizeBookDiscount.getDiscountedTotalSum(input), .0d);
    }

    @Test
    public void shouldGiveMaxDiscountForOneSet() {
        Map<String, Integer> input = new HashMap<String, Integer>() {{
            put("A", 1);
            put("B", 1);
            put("C", 1);
            put("D", 1);
            put("E", 1);
        }};
        Assert.assertEquals(30, maximizeBookDiscount.getDiscountedTotalSum(input), .0d);
    }

    @Test
    public void shouldGiveMaxDiscountForTwoSet() {
        Map<String, Integer> input = new HashMap<String, Integer>() {{
            put("A", 2);
            put("B", 2);
            put("C", 2);
            put("D", 2);
            put("E", 2);
        }};
        Assert.assertEquals(60, maximizeBookDiscount.getDiscountedTotalSum(input), .0d);
    }

    @Test
    public void shouldGiveMaxDiscountForRandomSet() {
        Map<String, Integer> input = new HashMap<String, Integer>() {{
            put("A", 2);
            put("B", 2);
            put("C", 2);
            put("D", 1);
            put("E", 1);
        }};
        Assert.assertEquals(51.6d, maximizeBookDiscount.getDiscountedTotalSum(input), .0d);
    }
}
