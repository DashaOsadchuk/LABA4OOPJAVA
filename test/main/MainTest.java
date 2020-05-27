package main;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    Main main;

    @BeforeEach
    void setUp() {
        main = new Main();
    }

    @Test
    void testCalcY() {
        double a = 2.4;
        double[] expected = new double[3];
        expected[0] = -0.0906; expected[1] = 0.2412; expected[2] = 7015.9638;
        double result = main.calcY(1, a);
        assertEquals(expected[0], result, 0.001, "y incorrect!");
        result = main.calcY(2.4, a);
        assertEquals(expected[1], result, 0.001, "y incorrect!");
        result = main.calcY(5, a);
        assertEquals(expected[2], result, 0.001, "y incorrect!");
    }

    @Test
    void testGetSumAndArif() {
        double[] expected = new double[2];
        expected[0] = 0; expected[1] = 0;
        int a = main.calcN(0.01);
        double[] buff = main.createArr(a);
        double[] result = main.getSumAndArif(buff);
        assertEquals(expected[0], result[0], 0, "sum of elements not same!");
        assertEquals(expected[1], result[1], 0, "middle arithmetical is incorrect!");
    }

    @Test
    void testCalcN() {
        int expected = 401;
        int result = main.calcN(0.01);
        assertEquals(expected,result,0,"amount of elements not same!");
    }
}