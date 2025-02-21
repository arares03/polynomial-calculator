package model;

import java.util.HashMap;
import java.util.Map;

public class Polynomial {
    private HashMap<Integer, Double> terms;

    public Polynomial() {
        this.terms = new HashMap<>();
    }

    public void parseString(String polynomialString) {
        if(polynomialString.isEmpty())
            return;
        terms.clear();
        if (polynomialString.startsWith("x")) {
            polynomialString = "+1" + polynomialString;
        }
        else {
            if (!(polynomialString.startsWith("-") || polynomialString.startsWith("+")))
            {
                polynomialString = "+" + polynomialString;

            }

        }
        polynomialString = polynomialString.replaceAll("(?<=[+-])x", "1x");
        polynomialString = polynomialString.replaceAll("x([+-]|$)", "x^1$1");

        String[] termStrings = polynomialString.split("(?=[+-])");
        for (String termString : termStrings) {

            termString = termString.trim();

            String[] parts = termString.split("x\\^?");

            double coefficient;
            int power;

            parts[0] = parts[0].substring(1);

            if (parts.length == 1) {
                coefficient = Double.parseDouble(parts[0].trim());
                power = 0;
            } else {
                coefficient = Double.parseDouble(parts[0].trim());;
                power =Integer.parseInt(parts[1].trim());
            }

            if (termString.startsWith("-")) {
                coefficient = -coefficient;
            }

            System.out.println(coefficient);
            System.out.println(power);

            terms.put(power, coefficient);
        }
    }

    public int getHighestPower() {
        if (terms.isEmpty()) {
            return 0;
        }
        int maxPower = Integer.MIN_VALUE;
        for (int power : terms.keySet()) {
            if (power > maxPower) {
                maxPower = power;
            }
        }
        return maxPower;
    }
    public void showTerms() {  // functie debug
        if (terms.isEmpty()) {
            System.out.println("Polynomial is empty.");
            return;
        }

        System.out.println("Polynomial Terms:");
        for (int power : terms.keySet()) {
            double coefficient = terms.get(power);
            if (power == 0) {
                System.out.println(coefficient);
            } else if (power == 1) {
                System.out.println(coefficient + "x");
            } else {
                System.out.println(coefficient + "x^" + power);
            }
        }
    }

    public String polynomialToString() {
        StringBuilder builder = new StringBuilder();
        boolean isFirstTerm = true;

        for (int power : terms.keySet()) {
            double coefficient = terms.get(power);

            if (coefficient >= 0 && !isFirstTerm) {
                builder.append(" + ");
            } else if (coefficient < 0) {
                builder.append(" - ");
            }

            double absCoefficient = Math.abs(coefficient);
            if (absCoefficient != 1 || power == 0) {
                builder.append(absCoefficient);
            }

            if (power > 0) {
                builder.append("x");
            }

            if (power > 1) {
                builder.append("^").append(power);
            }

            isFirstTerm = false;
        }

        if (builder.isEmpty()) {
            return "0";
        }

        return builder.toString();
    }
    public HashMap<Integer, Double> getTerms() {
        return terms;
    }
}
