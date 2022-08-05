import java.util.Scanner;

/**
 * This class implements main method for calculating
 * Beta function for all positive integers.
 *
 * @author Smit Pateliya
 * @version 1.0
 */
public final class BetaMain {
    private BetaMain() {
    }

    /**
     * This is starting point of the Program.
     *
     * @param args This stores all command line
     *             arguments which is given when progrqam
     *             executes.
     */
    public static void main(final String[] args) {
        Scanner keyboardInput = new Scanner(System.in);
        System.out.println("Welcome to Program to find Beta Function!");
        System.out.println("To calculate Beta function, We need 2 values.");
        System.out.println("You Should enter positive real numbers not"
                + " more than 200.");
        System.out.println("This program calculates beta function"
                + " with the help of "
                + "Stirling's approximation for factorials.");
        double p;
        double q;
        double r;
        Beta beta = new Beta();
        while (true) {
            try {
                System.out.print("Enter the first Value P: ");
                p = Double.parseDouble(keyboardInput.nextLine());
                System.out.print("Enter the Value Q: ");
                q = Double.parseDouble(keyboardInput.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("You have not entered numbers. "
                        + "Please enter numbers "
                        + "only!!");
                continue;
            }
            if (beta.validateInputs(p)) {
                System.out.println("You have entered incorrect value of P.");
                continue;
            }
            if (beta.validateInputs(q)) {
                System.out.println("You have entered incorrect value of Q.");
                continue;
            }
            r = p + q;
            if (beta.validateInputs(r)) {
                System.out.println("The sum of P and Q is greater than 200 or less than 0. " +
                        "Please, enter value of P and Q such as the sum of P and Q is less " +
                        "than 200 and more than 0");
                continue;
            }
            break;
        }
        double betaFunctionResult = beta.calculateBetaStirling(p, q, r);
        System.out.println("The Result of Beta Function by Stirling's approximation is  "
                + betaFunctionResult + "This method is not accurate. Result could be " +
                "different by huge margin for large numbers");

        if (p % 1 == 0 && q % 1 == 0 && r % 1 == 0) {
            double betaFunctionResultFactorial = beta.calculateBetaFactorial(p, q, r);
            System.out.println("The Result of Beta Function by Factorial is  "
                    + betaFunctionResultFactorial + "\nThis method is super accurate for all" +
                    " " +
                    "positive non fractional numbers.");
        } else {
            System.out.println("Factorial method for finding beta function can not use for " +
                    "fractional numbers.");
        }
    }
}
