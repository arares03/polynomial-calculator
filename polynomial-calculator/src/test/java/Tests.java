import logic.Operations;
import model.Polynomial;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Tests {

    @Test
    public void addTest() {
        try {
            Polynomial p1 = new Polynomial();
            Polynomial p2 = new Polynomial();
            Polynomial expectedResult = new Polynomial();

            p1.parseString("4x^4 - 3x^3 + 2x^2 - x + 7");
            p2.parseString("2x^3 - 5x^2 + 3x - 1");
            expectedResult.parseString("4x^4 - x^3 - 3x^2 + 4x + 6");

            assertEquals(expectedResult.polynomialToString(), Operations.add(p1, p2).polynomialToString());
        } catch (Exception e) {
            System.out.println("Error in addTest: " + e.getMessage());
        }
    }

    @Test
    public void subtractTest() {
        try {
            Polynomial p1 = new Polynomial();
            Polynomial p2 = new Polynomial();
            Polynomial expectedResult = new Polynomial();

            p1.parseString("4x^4 - 3x^3 + 2x^2 - x + 7");
            p2.parseString("2x^3 - 5x^2 + 3x - 1");
            expectedResult.parseString("4x^4 - 5x^3 + 7x^2 - 4x + 8");

            assertEquals(expectedResult.polynomialToString(), Operations.subtract(p1, p2).polynomialToString());
        } catch (Exception e) {
            System.out.println("Error in subtractTest: " + e.getMessage());
        }
    }

    @Test
    public void multiplyTest() {
        try {
            Polynomial p1 = new Polynomial();
            Polynomial p2 = new Polynomial();
            Polynomial expectedResult = new Polynomial();

            p1.parseString("2x^3 + 3x^2 - 4x + 5");
            p2.parseString("x^2 - 2x + 1");
            expectedResult.parseString("2x^5 - x^4 - x^3 + 11x^2 - 6x + 5");

            assertEquals(expectedResult.polynomialToString(), Operations.multiply(p1, p2).polynomialToString());
        } catch (Exception e) {
            System.out.println("Error in multiplyTest: " + e.getMessage());
        }
    }

    @Test
    public void divideTest() {
        try {
            Polynomial p1 = new Polynomial();
            Polynomial p2 = new Polynomial();

            p1.parseString("4x^3 - 2x^2 + 6x - 5");
            p2.parseString("x^2 - 1");

            String expectedQuotient = " - 2.0 + 4.0x";

            assertEquals(expectedQuotient, Operations.divide(p1, p2).polynomialToString());
        } catch (Exception e) {
            System.out.println("Error in divideTest: " + e.getMessage());
        }
    }

    @Test
    public void differentiationTest() {
        try {
            Polynomial p = new Polynomial();
            Polynomial expectedResult = new Polynomial();

            p.parseString("3x^3 + 2x^2 + x - 5");
            expectedResult.parseString("9x^2 + 4x + 1");

            assertEquals(expectedResult.polynomialToString(), Operations.differentiation(p).polynomialToString());
        } catch (Exception e) {
            System.out.println("Error in differentiationTest: " + e.getMessage());
        }
    }

    @Test
    public void integrationTest() {
        try {
            Polynomial p = new Polynomial();
            Polynomial expectedResult = new Polynomial();

            p.parseString("4x^3+3x^2+x-5");
            expectedResult.parseString(" - 5.0x + 0.5x^2 + x^3 + x^4");

            assertEquals(expectedResult.polynomialToString(), Operations.integration(p).polynomialToString());
        } catch (Exception e) {
            System.out.println("Error in integrationTest: " + e.getMessage());
        }
    }
}
