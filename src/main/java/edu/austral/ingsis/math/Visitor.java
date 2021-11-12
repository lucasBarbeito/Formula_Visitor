package edu.austral.ingsis.math;

import edu.austral.ingsis.math.operators.*;

public interface Visitor {

    public double visit(SumOperator sum , double left, double right);
    public double visit(SubtractOperator sutract , double left, double right);
    public double visit(DivisionOperator div , double left, double right);
    public double visit(MultiplyOperator mult , double left, double right);
    public double visit(ExponentOperator power , double left, double right);




}
