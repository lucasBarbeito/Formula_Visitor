package edu.austral.ingsis.math.operators;

import edu.austral.ingsis.math.Visitor;

public class ModulusOperator implements Operator {
    private final String name = "|";

    @Override
    public double accept(Visitor visitor , double value, double right) {
        return visitor.visit(this,value);
    }

    public String getName() {
        return name;
    }
}
