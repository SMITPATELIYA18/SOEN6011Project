import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class handles JUnit for Beta Class.
 * @author Smit Pateliya
 * @version 1.0
 */
class BetaTest {
    Beta beta;

    /**
     * This method sets beta object before every Test.
     */
    @BeforeEach
    void setUp() {
        beta = new Beta();
    }

    /**
     * This method validates inputs.
     */
    @Test
    void validateInputs() {
        assertTrue(beta.validateInputs(210));
        assertTrue(beta.validateInputs(201));
        assertTrue(beta.validateInputs(0));
        assertTrue(beta.validateInputs(-1));
        assertFalse(beta.validateInputs(200));
        assertFalse(beta.validateInputs(34));
        assertFalse(beta.validateInputs(1));
    }

    /**
     * This method checks power1 function
     */
    @Test
    void power1() {
        assertEquals(beta.power1(2, 3), Math.pow(2, 3));
        assertEquals(beta.power1(15,99), 2.710407850234768E116);
    }

    /**
     * This method tests factorial method.
     */
    @Test
    void factorial() {
        assertEquals(beta.factorial(6),720);
        assertEquals(beta.factorial(99),9.33262154439441E155);
    }

    /**
     * This method tests logn method.
     */
    @Test
    void logn() {
        assertEquals(beta.logn(2),0.6931471805599451);
        assertEquals(beta.logn(34),3.5263597384972347);
    }

    /**
     * This method tests calculate Power method
     */
    @Test
    void calculatePower() {
        assertEquals(beta.calculatePower(10,0.5), 3.162277660168378);
        assertEquals(beta.calculatePower(20,3.5),35777.08762161744);
    }

    /**
     * This method tests calculateSquareRoot Method
     */
    @Test
    void calculateSquareRoot() {
        assertEquals(beta.calculateSquareRoot(2),1.41);
        assertEquals(beta.calculateSquareRoot(10000),100);
    }

    /**
     * This method tests calculateGamma Method
     */
    @Test
    void calculateGamma() {
        assertEquals(beta.calculateGamma(1.5),0.8389565525264959);
        assertEquals(beta.calculateGamma(171.6),5.342367942856751E125);
    }

    /**
     * This method tests calculateBeta Method
     */
    @Test
    void calculateBeta() {
        assertEquals(beta.calculateBeta(10,20,30),4.949413583639931E-9);
        assertEquals(beta.calculateBeta(50,60,50+60),6.233885028053785E24);
    }
}