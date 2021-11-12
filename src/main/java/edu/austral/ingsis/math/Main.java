package edu.austral.ingsis.math;

import edu.austral.ingsis.math.operators.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Operator sumOperator = new SumOperator();
    private static Operator subtractOperator = new SubtractOperator();
    private static Operator multiplyOperator = new MultiplyOperator();
    private static Operator divisionOperator = new DivisionOperator();
    private static Operator exponentOperator = new ExponentOperator();
    private static ModulusOperator modulusOperator = new ModulusOperator();
    private static Engine engine = new Engine();

    public static void main(String[] args) {
        ArrayList<Expression> expressions = new ArrayList<>();
        String repeat;

        do {
            createExpressions(expressions);
            System.out.println("Choose an equation");
            System.out.println("1) 1 + x ");
            System.out.println("2) 12 / div");
            System.out.println("3) (9 / x) * y");
            System.out.println("4) (27 / a) ^ b");
            System.out.println("5) z ^ (1/2)");
            System.out.println("6) (5 - i) * 8");
            System.out.println("7) |value| - 8");
            switch (scanner.nextInt() -1){
                case 0:
                    particularCase(0,expressions);
                    break;
                case 1:
                    particularCase(1,expressions);
                    break;
                case 2:
                    particularCase(2,expressions);
                    break;
                case 3:
                    particularCase(3,expressions);
                    break;
                case 4:
                    particularCase(4,expressions);
                    break;
                case 5:
                    particularCase(5,expressions);
                    break;
                case 6:
                    particularCase(6,expressions);
                    break;
            }
            System.out.println("Do you want to try again? Press y");
            expressions.clear();
            repeat = scanner.next();
        }while (Objects.equals(repeat, "y"));
        System.out.println("Goodbye!");
    }

    private static void particularCase(int n, ArrayList<Expression> expressions){
        while (engine.getVariableAmount(expressions.get(n),0) > 0){
            checkEmptyValues(expressions.get(n));
            System.out.println(engine.printer(expressions.get(n),""));
        }
            System.out.println(engine.solve(expressions.get(n)));
    }

    private static void checkEmptyValues(Evaluable evaluable){
        if (evaluable instanceof Operand){
            if (Double.isNaN(((Operand) evaluable).getValue())){
                System.out.println("Do you want to define a value for variable " + ((Operand) evaluable).getName() +" ? Press y");
                if (scanner.next().equals("y")){
                    System.out.println("Define a value for variable "+ ((Operand) evaluable).getName());
                    ((Operand) evaluable).setValue(scanner.nextDouble());
                }
            }
            }else {
            checkEmptyValues(((Expression) evaluable).getLeftEvaluable());
            checkEmptyValues(((Expression) evaluable).getRightEvaluable());
        }
    }
    private static void createExpressions(ArrayList<Expression> expressions){
        Expression expression1 = new Expression(new Operand(1),new Operand("x"),sumOperator);
        Expression expression2 = new Expression(new Operand(12),new Operand("div"),divisionOperator);
        Expression expression3 = new Expression(
                new Expression(new Operand(9),new Operand("x"),divisionOperator),
                new Operand("y"),
                multiplyOperator);

        Expression expression4 = new Expression(
                new Expression(new Operand(27),new Operand("a"),divisionOperator),
                new Operand("b"),exponentOperator);

        Expression expression5 = new Expression(
                new Operand("z"),
                new Expression(new Operand(1),new Operand(2),divisionOperator),
                exponentOperator
        );

        Expression expression6 = new Expression(
                new Expression(new Operand(5),new Operand("i"),subtractOperator),
                new Operand(8),
                multiplyOperator
        );
        Expression expression7 = new Expression(new Operand("value",modulusOperator),new Operand(8),subtractOperator);

        expressions.add(expression1);
        expressions.add(expression2);
        expressions.add(expression3);
        expressions.add(expression4);
        expressions.add(expression5);
        expressions.add(expression6);
        expressions.add(expression7);

    }
}
