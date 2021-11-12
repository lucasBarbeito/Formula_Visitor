package edu.austral.ingsis.math;

import edu.austral.ingsis.math.operators.ModulusOperator;
import edu.austral.ingsis.math.operators.OperatorVisitor;

public class Engine {

    OperatorVisitor operatorVisitor;

    public Engine(){
        operatorVisitor = new OperatorVisitor();
    }

    public double solve(Evaluable evaluable){
        if (evaluable instanceof Operand){
            if (((Operand) evaluable).getAltOperator() instanceof ModulusOperator){
                return Math.abs(((Operand) evaluable).getValue());
            }else {
                return ((Operand) evaluable).getValue();
            }
        }else {
            if (((Expression) evaluable).getOperator() instanceof ModulusOperator){
                return ((Expression) evaluable).getAltOperator().accept(operatorVisitor,
                        solve(((Expression) evaluable).getLeftEvaluable()),
                        solve(((Expression) evaluable).getRightEvaluable()));
            }else{
                return  ((Expression) evaluable).getOperator().accept(operatorVisitor,
                        solve(((Expression) evaluable).getLeftEvaluable()),
                        solve(((Expression) evaluable).getRightEvaluable()));
            }
        }
    }

    public String printer(Evaluable evaluable, String string){
        String returnString = "";
        if (evaluable instanceof Expression){
            returnString = (((Expression) evaluable).getAltOperator() instanceof ModulusOperator ? "|" : "(" ) + returnString + printer(((Expression) evaluable).getLeftEvaluable(),returnString);
            returnString = returnString + " " + ((Expression) evaluable).getOperator().getName() + " ";
            returnString = returnString + printer(((Expression) evaluable).getRightEvaluable(),returnString) + (((Expression) evaluable).getAltOperator() instanceof ModulusOperator ? "|" : ")" );
        }else{
            if (((Operand) evaluable).getAltOperator() instanceof ModulusOperator){
                return "|" + ((Operand) evaluable).getName() + "|";
            }else {
                return ((Operand) evaluable).getName();
            }
        }
        return returnString;
    }

    public double getVariableAmount(Evaluable evaluable, double amount){
        double returnAmount = 0;
        if (evaluable instanceof Operand){
            if (Double.isNaN(((Operand) evaluable).getValue())) returnAmount+=1;
        }else {
            returnAmount += getVariableAmount(((Expression) evaluable).getLeftEvaluable(),returnAmount);
            returnAmount += getVariableAmount(((Expression) evaluable).getRightEvaluable(),returnAmount);
        }
        return returnAmount;
    }
}
