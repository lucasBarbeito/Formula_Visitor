package edu.austral.ingsis.math;

import edu.austral.ingsis.math.operators.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionWithVariablesTest {

    Engine engine = new Engine();
    SumOperator sumOperator = new SumOperator();
    SubtractOperator subtractOperator =  new SubtractOperator();
    DivisionOperator divisionOperator = new DivisionOperator();
    MultiplyOperator multiplyOperator = new MultiplyOperator();
    ExponentOperator exponentOperator = new ExponentOperator();
    ModulusOperator modulusOperator = new ModulusOperator();
    /**
     * Case 1 + x where x = 3
     */
    @Test
    public void shouldResolveFunction1() {
        Expression expression = new Expression(new Operand(1),new Operand("x",3),sumOperator);
        assertThat(engine.solve(expression), equalTo(4d));
        System.out.println(engine.solve(expression));
    }

    /**
     * Case 12 / div where div = 4
     */
    @Test
    public void shouldResolveFunction2() {
        Expression expression = new Expression(new Operand(12),new Operand("div",4),divisionOperator);
        assertThat(engine.solve(expression), equalTo(3d));
        System.out.println(engine.solve(expression));
    }

    /**
     * Case (9 / x) * y where x = 3 and y = 4
     */
    @Test
    public void shouldResolveFunction3() {
        Expression expression = new Expression(
                new Expression(new Operand(9),new Operand("x",3),divisionOperator),
                new Operand("y",4),
                multiplyOperator);
        assertThat(engine.solve(expression), equalTo(12d));
        System.out.println(engine.solve(expression));
    }

    /**
     * Case (27 / a) ^ b where a = 9 and b = 3
     */
    @Test
    public void shouldResolveFunction4() {
        Expression expression = new Expression(
                new Expression(new Operand(27),new Operand("a",9),divisionOperator),
                new Operand("b",3),exponentOperator);
        assertThat(engine.solve(expression), equalTo(27d));
        System.out.println(engine.solve(expression));
    }

    /**
     * Case z ^ (1/2) where z = 36
     */
    @Test
    public void shouldResolveFunction5() {
        Expression expression = new Expression(
          new Operand("z",36),
          new Expression(new Operand(1),new Operand(2),divisionOperator),
          exponentOperator
        );
        assertThat(engine.solve(expression), equalTo(6d));
        System.out.println(engine.solve(expression));
    }

    /**
     * Case |value| - 8 where value = 8
     */
    @Test
    public void shouldResolveFunction7() {

        Expression expression = new Expression(new Operand("value",-8,modulusOperator),new Operand(8),subtractOperator);
        assertThat(engine.solve(expression), equalTo(0d));
        System.out.println(engine.solve(expression));

    }
    /**
     * Case (5 - i) * 8 where i = 2
     */
    @Test
    public void shouldResolveFunction8() {
        Expression expression = new Expression(
                new Expression(new Operand(5),new Operand("i",2),subtractOperator),
                new Operand(8),
                multiplyOperator
        );
        assertThat(engine.solve(expression), equalTo(24d));
        System.out.println(engine.solve(expression));
    }
    /**
     * Case |value - 8| where value = 8
     */
    @Test
    public void shouldResolveFunction9() {
        Expression expression = new Expression(new Operand("value",-8),new Operand(8),subtractOperator, modulusOperator);
        System.out.println(engine.solve(expression));
        assertThat(engine.solve(expression), equalTo(-16d));

    }
}
