package tddtraining;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordWrappingTest {

    private WordWrapping wordWrapping;

    @Before
    public void testWordWrapping() {
        wordWrapping = new WordWrapping();
    }

    @Test
    public void shouldFitInLineWithOneChar() {
        Assert.assertEquals("x\nx\nx", wordWrapping.format("xxx", 1));
        Assert.assertEquals("x\nxx", wordWrapping.wrap("x xx", 3));
    }

    @Test
    public void shouldFitInLineWithOneWord() {
        Assert.assertEquals("test", wordWrapping.format("test", 4));
    }

    @Test
    public void shouldFitInLineWithOneLongWord() {
        Assert.assertEquals("test", wordWrapping.format("test", 5));
    }

    @Test
    public void shouldFitInLineWithTwoWord() {
        Assert.assertEquals("easy\nexam\nple", wordWrapping.format("easy example", 4));
    }

    @Test
    public void shouldFitInLineWithThreeWord() {
        Assert.assertEquals("a simple\nsizing", wordWrapping.format("a simple sizing", 8));
    }

    @Test
    public void shouldFitInLineWithMultiWord() {
        Assert.assertEquals("a simple\nsizing\neasy\nexample", wordWrapping.format("a simple sizing easy example", 8));
    }
}
