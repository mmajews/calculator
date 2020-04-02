package com.company;

import com.company.exceptions.DivideByZeroException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

/**
 * Test for {@link SimpleCalculator}
 */
public class SimpleCalculatorTest {

    private static final Calculator calculator = new SimpleCalculator();

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void shouldCorrectlyEvaluateSimpleCommands() {
        List<String> input = new ArrayList<>();
        input.add("ADD 2");
        input.add("ADD 2");
        input.add("MULTIPLY BY 3");
        input.add("DISPLAY");

        List<Integer> output = calculator.calculate(input);

        Assert.assertEquals(1, output.size());
        Assert.assertEquals(12, (int) output.get(0));
    }

    @Test
    public void shouldCorrectlyDisplayTheSameResultWhenCallingDisplayMultipleTimes() {
        List<String> input = new ArrayList<>();
        input.add("ADD 2");
        input.add("ADD 2");
        input.add("MULTIPLY BY 3");
        input.add("DISPLAY");
        input.add("DISPLAY");
        input.add("DISPLAY");
        input.add("DISPLAY");

        List<Integer> output = calculator.calculate(input);

        Assert.assertEquals(4, output.size());
        for (Integer integer : output) {
            Assert.assertEquals(12, (int) integer);
        }
    }

    @Test
    public void shouldReturnEmptyCollectionWhenNoDisplay(){
        List<String> input = new ArrayList<>();
        input.add("ADD 2");
        input.add("ADD 2");
        input.add("MULTIPLY BY 3");
        input.add("DIVIDE BY 3");
        input.add("ADD 3");

        List<Integer> output = calculator.calculate(input);

        Assert.assertTrue(output.isEmpty());
    }

    @Test
    public void shouldThrowExceptionWhenDivideByZero(){
        exceptionRule.expect(DivideByZeroException.class);
        exceptionRule.expectMessage("User tried to divided by 0, expr: DIVIDE BY 0");

        List<String> input = new ArrayList<>();
        input.add("ADD 2");
        input.add("ADD 8");
        input.add("MULTIPLY BY 3");
        input.add("DIVIDE BY 0");
        input.add("ADD 3");

        List<Integer> output = calculator.calculate(input);
    }

    @Test
    public void shouldCorrectlyGiveResultsWithMultipleDivides(){
        List<String> input = new ArrayList<>();
        input.add("ADD 200");
        input.add("ADD 8");
        input.add("MULTIPLY BY 3");
        input.add("DIVIDE BY 5");
        input.add("ADD 3");
        input.add("DISPLAY");
        input.add("ADD 10");
        input.add("SUBTRACT 5");
        input.add("DISPLAY");
        input.add("ADD 50");
        input.add("DISPLAY");

        List<Integer> output = calculator.calculate(input);
        Assert.assertEquals(3, output.size());
        Assert.assertEquals(127, (int)output.get(0));
        Assert.assertEquals(132, (int)output.get(1));
        Assert.assertEquals(182, (int)output.get(2));
    }

}
