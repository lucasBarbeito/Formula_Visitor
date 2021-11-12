package edu.austral.ingsis.math;
import edu.austral.ingsis.math.operators.ModulusOperator;
import edu.austral.ingsis.math.operators.Operator;


public class Expression implements Evaluable {
    private Evaluable leftEvaluable;
    private Evaluable rightEvaluable;
    private Operator operator;
    private Operator altOperator;

    public Expression(Evaluable leftEvaluable, Evaluable rightEvaluable, Operator operator){
        this.leftEvaluable = leftEvaluable;
        this.rightEvaluable = rightEvaluable;
        this.operator = operator;
    }
    public Expression(Evaluable leftEvaluable, Evaluable rightEvaluable, Operator operator, Operator altOperator){
        if (!(altOperator instanceof ModulusOperator)) throw new RuntimeException("Must be modulus operator");
        this.leftEvaluable = leftEvaluable;
        this.rightEvaluable = rightEvaluable;
        this.operator = operator;
        this.altOperator = altOperator;
    }

    public Evaluable getLeftEvaluable() {
        return leftEvaluable;
    }

    public Evaluable getRightEvaluable() {
        return rightEvaluable;
    }

    public Operator getOperator() {
        return operator;
    }

    public Operator getAltOperator() {
        return altOperator;
    }
}
