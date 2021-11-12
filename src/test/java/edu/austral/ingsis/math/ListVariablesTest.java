package edu.austral.ingsis.math;

import edu.austral.ingsis.math.operators.*;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ListVariablesTest {
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
        Expression expression = new Expression(new Operand(1),new Operand("x"),sumOperator);
        assertThat(engine.getVariableAmount(expression,0), equalTo(1d));
        System.out.println(engine.getVariableAmount(expression,0));
    }
    /**
     * Case (9 / x) * y where x = 3 and y = 4
     */
    @Test
    public void shouldResolveFunction3() {
        Expression expression = new Expression(
                new Expression(new Operand(9),new Operand("x"),divisionOperator),
                new Operand("y"),
                multiplyOperator);
        assertThat(engine.getVariableAmount(expression,0), equalTo(2d));
        System.out.println(engine.getVariableAmount(expression,0));
    }
}
