package edu.austral.ingsis.math;
import edu.austral.ingsis.math.operators.Operator;


public class Expression implements Evaluable {
    private Evaluable leftEvaluable;
    private Evaluable rightEvaluable;
    private Operator operator;

//    @Override
//    public double accept(Visitor visitor) {
//        return visitor.visit(this);
//    }

    public Expression(Evaluable leftEvaluable, Evaluable rightEvaluable, Operator operator){
        this.leftEvaluable = leftEvaluable;
        this.rightEvaluable = rightEvaluable;
        this.operator = operator;
    }
    @Override
    public boolean isExpression(){
        return false;
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
    //    public Expression(ArrayList<Evaluable> evaluables, Operator operator){
//        this.evaluables = evaluables;
//        this.operator = operator;
//    }


//    @Override
//    public double evaluate() {
//        return 0;
//    }

//    public ArrayList<Evaluable> getEvaluables() {
//        return evaluables;
//    }

//    public Operator getOperator() {
//        return operator;
//    }
}
