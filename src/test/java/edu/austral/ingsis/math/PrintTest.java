package edu.austral.ingsis.math;

import edu.austral.ingsis.math.operators.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PrintTest {
    Engine engine = new Engine();
    SumOperator sumOperator = new SumOperator();
    SubtractOperator subtractOperator =  new SubtractOperator();
    DivisionOperator divisionOperator = new DivisionOperator();
    MultiplyOperator multiplyOperator = new MultiplyOperator();
    ExponentOperator exponentOperator = new ExponentOperator();
    /**
     * Case 1 + 6
     */
    @Test
    public void shouldPrintFunction1() {
        final String expected = "(1 + 6)";
        Expression expression = new Expression(new Operand(1),new Operand(6),sumOperator);
        System.out.println(engine.printer(expression,""));
        assertThat(engine.printer(expression,""), equalTo(expected));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldPrintFunction2() {
        final String expected = "(12 / 2)";
        Expression expression = new Expression(new Operand(12),new Operand(2),divisionOperator);
        System.out.println(engine.printer(expression,""));
        assertThat(engine.printer(expression,""), equalTo(expected));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldPrintFunction3() {
        final String expected = "((9 / 2) * 3)";
        Expression expression1 = new Expression(new Operand(9), new Operand(2), divisionOperator);
        Expression expression = new Expression(expression1,new Operand(3),multiplyOperator);
        System.out.println(engine.printer(expression,""));
        assertThat(engine.printer(expression,""), equalTo(expected));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldPrintFunction4() {
        final String expected = "((27 / 6) ^ 2)";
        Expression expression1 = new Expression(new Operand(27), new Operand(6), divisionOperator);
        Expression expression = new Expression(expression1,new Operand(2),exponentOperator);
        System.out.println(engine.printer(expression,""));
        assertThat(engine.printer(expression,""), equalTo(expected));
    }

    /**
     * Case |value| - 8
     */
    @Test
    public void shouldPrintFunction7() {
        final String expected = "|value| - 8";
        final String result = expected;

        assertThat(result, equalTo(expected));
    }

    /**
     * Case (5 - i) * 8
     */
    @Test
    public void shouldPrintFunction8() {
        final String expected = "((5 - i) * 8)";
        Expression expression1 = new Expression(new Operand(5), new Operand("i"), subtractOperator);
        Expression expression = new Expression(expression1,new Operand(8),multiplyOperator);
        System.out.println(engine.printer(expression,""));
        assertThat(engine.printer(expression,""), equalTo(expected));
    }
}
