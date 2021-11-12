package edu.austral.ingsis.math;

import edu.austral.ingsis.math.operators.OperatorVisitor;

public class Engine {

    OperatorVisitor operatorVisitor;

    public Engine(){
        operatorVisitor = new OperatorVisitor();
    }

    public double solve(Evaluable evaluable){
        if (evaluable instanceof Operand){
            return ((Operand) evaluable).getValue();
        }else {
           return  ((Expression) evaluable).getOperator().accept(operatorVisitor,
                    solve(((Expression) evaluable).getLeftEvaluable()),
                    solve(((Expression) evaluable).getRightEvaluable()));
        }
    }

    public String printer(Evaluable evaluable, String string){
        String returnString = "";
        if (evaluable instanceof Expression){
            returnString = "(" + returnString + printer(((Expression) evaluable).getLeftEvaluable(),returnString);
            returnString = returnString + " " + ((Expression) evaluable).getOperator().getName() + " ";
            returnString = returnString + printer(((Expression) evaluable).getRightEvaluable(),returnString) +")";
        }else{
            return ((Operand) evaluable).getName();
        }
        return returnString;
    }
}
