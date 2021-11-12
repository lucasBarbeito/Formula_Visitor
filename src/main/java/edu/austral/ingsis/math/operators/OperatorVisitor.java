package edu.austral.ingsis.math.operators;

import edu.austral.ingsis.math.Visitor;

public class OperatorVisitor implements Visitor {
    @Override
    public double visit(SumOperator sum, double left, double right) {
        return left + right;
    }
    public double visit(SubtractOperator subtract, double left, double right) {
        return left - right;
    }
    @Override
    public double visit(DivisionOperator div, double left, double right) {
        return left / right;
    }
    public double visit(MultiplyOperator mult, double left, double right) {
        return left * right;
    }
    public double visit(ExponentOperator power, double left, double right) {
        return Math.pow(left,right);
    }
    public double visit(ModulusOperator modulus, double value) {
        return Math.abs(value);
    }
}
