package edu.austral.ingsis.math.operators;

import edu.austral.ingsis.math.Visitor;

public interface Operator {

    public double accept(Visitor visitor, double left, double right);

    public String getName();
}
