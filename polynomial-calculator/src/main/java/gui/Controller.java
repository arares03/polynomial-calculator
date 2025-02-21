package gui;

import javax.swing.*;

import logic.Operations;
import model.Polynomial;

public class Controller implements AppListener
{
    public static void main( String[] args )
    {

        JFrame frame = new View("Calculator", new Controller());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }

    @Override
    public String processData(String firstNumber, String secondNumber, String selectedOperation) {
        System.out.println("First Number: " + firstNumber);
        System.out.println("Second Number: " + secondNumber);
        System.out.println("Selected Operation: " + selectedOperation);

        Polynomial polynomial1 = new Polynomial();
        Polynomial polynomial2 = new Polynomial();

        polynomial1.parseString(firstNumber);
        polynomial2.parseString(secondNumber);

        polynomial1.showTerms();
        polynomial2.showTerms();

        String regex = "-?((\\d*\\.)?\\d+)?(x(\\^(\\d+))?)?((\\+|-)((\\d*\\.)?\\d+)?(x(\\^(\\d+))?)?)*";

        boolean shouldOperateWithFirst = firstNumber.matches(regex);
        boolean shouldOperateWithBoth = shouldOperateWithFirst && secondNumber.matches(regex);

        System.out.println(shouldOperateWithFirst);
        System.out.println(shouldOperateWithBoth);

        switch (selectedOperation) {
            case "Add":
                if (shouldOperateWithBoth)
                    polynomial1 = Operations.add(polynomial1, polynomial2);
                break;
            case "Subtract":
                if (shouldOperateWithBoth)
                    polynomial1 = Operations.subtract(polynomial1, polynomial2);
                break;
            case "Multiply":
                if (shouldOperateWithBoth)
                    polynomial1 = Operations.multiply(polynomial1, polynomial2);
                break;
            case "Derivative":
                if (shouldOperateWithFirst)
                    polynomial1 = Operations.differentiation(polynomial1);

                break;
            case "Integrate":
                if (shouldOperateWithFirst)
                    polynomial1 = Operations.integration(polynomial1);

                break;
            case "Division":
                if (shouldOperateWithBoth)
                    polynomial1 = Operations.divide(polynomial1, polynomial2);

                break;
            default:
                return "";
        }

        polynomial1.showTerms();
        return polynomial1.polynomialToString();
    }

}
