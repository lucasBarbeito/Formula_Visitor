package edu.austral.ingsis.math;

import edu.austral.ingsis.math.operators.ModulusOperator;
import edu.austral.ingsis.math.operators.Operator;

public class Operand implements Evaluable {

    final String name;
    double value;
    private Operator altOperator;


    public Operand(double value) {
        this.name = String.format("%.0f",value);
        this.value = value;
        this.altOperator = null;
    }

    public Operand(String name) {
        this.name = name;
        this.value = Double.NaN;
        this.altOperator = null;
    }
    public Operand(String name, double value){
        this.name = name;
        this.value = value;
        this.altOperator = null;
    }
    public Operand(double value, Operator altOperator) {
        if (!(altOperator instanceof ModulusOperator)) throw new RuntimeException("Must be modulus operator");
        this.name = String.format("%.0f",value);
        this.value = value;
        this.altOperator = altOperator;
    }

    public Operand(String name,Operator altOperator) {
        if (!(altOperator instanceof ModulusOperator)) throw new RuntimeException("Must be modulus operator");
        this.name = name;
        this.value = Double.NaN;
        this.altOperator = altOperator;
    }
    public Operand(String name,double value, Operator altOperator) {
        if (!(altOperator instanceof ModulusOperator)) throw new RuntimeException("Must be modulus operator");
        this.name = name;
        this.value = value;
        this.altOperator = altOperator;
    }

    public String getName() {
        return name;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public Operator getAltOperator() {
        return altOperator;
    }
}

