package edu.austral.ingsis.math;

import edu.austral.ingsis.math.operators.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ResolutionTest {

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
    public void shouldResolveSimpleFunction1() {
        Expression expression = new Expression(new Operand(1),new Operand(6),sumOperator);
        assertThat(engine.solve(expression), equalTo(7d));
        System.out.println(engine.solve(expression));
    }

    /**
     * Case 12 / 2
     */
    @Test
    public void shouldResolveSimpleFunction2() {
        Expression expression = new Expression(new Operand(12), new Operand(2), divisionOperator);
        assertThat(engine.solve(expression), equalTo(6d));
        System.out.println(engine.solve(expression));
    }

    /**
     * Case (9 / 2) * 3
     */
    @Test
    public void shouldResolveSimpleFunction3() {
        Expression expression1 = new Expression(new Operand(9), new Operand(2), divisionOperator);
        Expression expression = new Expression(expression1,new Operand(3),multiplyOperator);
        assertThat(engine.solve(expression), equalTo(13.5d));
        System.out.println(engine.solve(expression));
    }

    /**
     * Case (27 / 6) ^ 2
     */
    @Test
    public void shouldResolveSimpleFunction4() {
        Expression expression1 = new Expression(new Operand(27), new Operand(6), divisionOperator);
        Expression expression = new Expression(expression1,new Operand(2),exponentOperator);
        assertThat(engine.solve(expression), equalTo(20.25d));
        System.out.println(engine.solve(expression));
    }

    /**
     * Case 36 ^ (1/2)
     */
    @Test
    public void shouldResolveSimpleFunction5() {
        Expression expression1 = new Expression(new Operand(1), new Operand(2), divisionOperator);
        Expression expression = new Expression(new Operand(36),expression1,exponentOperator);
        assertThat(engine.solve(expression), equalTo(6d));
        System.out.println(engine.solve(expression));
    }

    /**
     * Case |136|
     */
    @Test
    public void shouldResolveSimpleFunction6() {
        final Double result = 136d;

        assertThat(result, equalTo(136d));
    }

    /**
     * Case |-136|
     */
    @Test
    public void shouldResolveSimpleFunction7() {
        final Double result = 136d;

        assertThat(result, equalTo(136d));
    }

    /**
     * Case (5 - 5) * 8
     */
    @Test
    public void shouldResolveSimpleFunction8() {
        Expression expression1 = new Expression(new Operand(5), new Operand(5), subtractOperator);
        Expression expression = new Expression(expression1,new Operand(8),multiplyOperator);
        assertThat(engine.solve(expression), equalTo(0d));
        System.out.println(engine.solve(expression));
    }
}
