package logic;

import model.Polynomial;

public class Operations {

    public static Polynomial add(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();
        for (int power : p1.getTerms().keySet()) {
            result.getTerms().put(power, p1.getTerms().get(power));
        }
        for (int power : p2.getTerms().keySet()) {
            double sum = result.getTerms().getOrDefault(power, 0.0) + p2.getTerms().get(power);
            result.getTerms().put(power, sum);
        }
        return result;
    }

    public static Polynomial subtract(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();
        for (int power : p1.getTerms().keySet()) {
            result.getTerms().put(power, p1.getTerms().get(power));
        }
        for (int power : p2.getTerms().keySet()) {
            double difference = result.getTerms().getOrDefault(power, 0.0) - p2.getTerms().get(power);
            if (difference != 0) {
                result.getTerms().put(power, difference);
            } else {
                result.getTerms().remove(power);
            }
        }
        return result;
    }

    public static Polynomial multiply(Polynomial p1, Polynomial p2) {
        Polynomial result = new Polynomial();
        for (int power1 : p1.getTerms().keySet()) {
            for (int power2 : p2.getTerms().keySet()) {
                int newPower = power1 + power2;
                double product = p1.getTerms().get(power1) * p2.getTerms().get(power2);
                result.getTerms().put(newPower, result.getTerms().getOrDefault(newPower, 0.0) + product);
            }
        }
        return result;
    }

    public static Polynomial differentiation(Polynomial p) {
        Polynomial result = new Polynomial();
        for (int power : p.getTerms().keySet()) {
            if (power != 0) {
                double coefficient = p.getTerms().get(power);
                double derivativeCoefficient = coefficient * power;
                result.getTerms().put(power - 1, derivativeCoefficient);
            }
        }
        return result;
    }

    public static Polynomial integration(Polynomial p) {
        Polynomial result = new Polynomial();
        for (int power : p.getTerms().keySet()) {
            double coefficient = p.getTerms().get(power);
            double integralCoefficient = coefficient / (power + 1);
            result.getTerms().put(power + 1, integralCoefficient);
        }
        return result;
    }

    public static Polynomial divide(Polynomial dividend, Polynomial divisor) {
        Polynomial quotient = new Polynomial();
        Polynomial remainder = dividend;


        while (!remainder.getTerms().isEmpty() && remainder.getHighestPower() >= divisor.getHighestPower()) {
            int divPower = remainder.getHighestPower() - divisor.getHighestPower();
            double divCoefficient = remainder.getTerms().get(remainder.getHighestPower()) / divisor.getTerms().get(divisor.getHighestPower());
            Polynomial temp = new Polynomial();
            temp.getTerms().put(divPower, divCoefficient);
            quotient = Operations.add(quotient, temp);
            Polynomial product = Operations.multiply(divisor, temp);
            remainder = Operations.subtract(remainder, product);
        }

        return quotient;
    }

}
