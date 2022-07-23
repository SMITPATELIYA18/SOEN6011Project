/**
 * This class has all methods which need
 * to calculate the value beta function successfully.
 *
 * @author Smit Pateliya
 * @version 1.1
 */
public final  class Beta {
    /**
     * This method validates input which is given by
     * user. So, program does not encounter
     * overflow errors.
     *
     * @param validate Positive real number entered
     *                by user.
     * @return True If value is more than 200 or less
     * than 0. Else it is returning false.
     */
    boolean validateInputs(final double validate) {
        return validate > 200 || validate <= 0;
    }

    /**
     * This method calculates power of the given value.
     *
     * @param value The value of which the power is to be determined
     * @param power The power of the given value.
     * @return The result of the value^power
     */
    double power1(final double value, final double power) {
        int exponent = (int) power;
        double result = 1;
        for (int i = 1; i <= exponent; i++) {
            result = result * value;
        }
        return result;
    }

    /**
     * This method calculates factorial
     *
     * @param value  The value of which the factorial is to be determined
     * @return The factorial of value.
     */
    double factorial(double value) {
        if (value <= 1) {
            return 1;
        } else {
            return (value * factorial(value - 1));
        }
    }

    /**
     * This methods evaluates natural logarithms of the given value.
     *
     * @param value The value of which the logarithms is to be determined.
     * @return The logarithms of value
     */
    double logn(final double value) {
        double result = 0;
        double intermediate = (value - 1) / (value + 1);
        for (int i = 1; i < 99; i++) {
            double inter = 2 * i - 1;
            result += (1 / inter) * power1(intermediate, inter);
        }
        return 2 * result;
    }

    /**
     * This method calculates power of the given value.
     *
     * @param value The value of which the power is to be determined
     * @param power The power of the given value.
     * @return The result of the value^power
     */
    double calculatePower(final double value, final double power) {
        double result = 0;
        for (int i = 0; i <= 99; i++) {
            double intermediate = power1((power * logn(value)), i);
            result = result + intermediate / factorial(i);
        }
        return result;
    }

    /**
     * This method calculates square root of the given value.
     *
     * @param value The value of which the square root is to be determined.
     * @return The result of the square root.
     */
    double calculateSquareRoot(final double value) {
        double squareRoot = value / 2;
        double result;
        do {
            result = squareRoot;
            squareRoot = (result + (value / result)) / 2;
        } while ((result - squareRoot) != 0);
        return squareRoot;
    }

    /**
     * This method calculates gamma function for
     * the given arguments with the help of
     * sterling's approximation method.
     *
     * @param value The value of which the gamma value is to be determined.
     * @return The result of the Gamma function.
     */
    double calculateGamma(final double value) {
        double e = Math.E;
        double pi = Math.PI;
        double intermediate1 = (2 * pi) / value;
        double intermediate2 = calculateSquareRoot(intermediate1);
        double intermediate3 = value / e;
        double intermediate4 = calculatePower(intermediate3, value);
        return intermediate2 * intermediate4;
    }

    /**
     * This method calculates the Beta function of the given values.
     *
     * @param p The value which is entered by user.
     * @param q The value which is entered by user.
     * @param r The supporting value to calculate the
     *          Beta function with the help of the
     *          Gamma Function.
     * @return The result of the Beta Function.
     */
    double calculateBeta(final double p, final double q, final double r) {
        double valueOfGammaForP = calculateGamma(p);
        double valueOfGammaForQ = calculateGamma(q);
        double valueOfGammaForR = calculateGamma(r);
        return valueOfGammaForP * valueOfGammaForQ / valueOfGammaForR;
    }
}
