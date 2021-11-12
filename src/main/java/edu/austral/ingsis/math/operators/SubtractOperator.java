package edu.austral.ingsis.math.operators;

import edu.austral.ingsis.math.Visitor;

public class SubtractOperator implements Operator{
    private final String name = "-";

    @Override
    public double accept(Visitor visitor , double left, double right) {
        return visitor.visit(this,left,right);
    }

    public String getName() {
        return name;
    }
}
