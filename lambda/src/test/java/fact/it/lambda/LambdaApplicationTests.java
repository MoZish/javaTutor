package fact.it.lambda;

import fact.it.lambda.primecalculator.PrimeCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
class LambdaApplicationTests {

    PrimeCalculator primeCalculator = new PrimeCalculator();

    @Test
    void testIsPrime() {
        Assertions.assertTrue(primeCalculator.isPrime(3));
        Assertions.assertTrue(primeCalculator.isPrime(5));
        Assertions.assertTrue(primeCalculator.isPrime(7));

        Assertions.assertFalse(primeCalculator.isPrime(-10));
        Assertions.assertFalse(primeCalculator.isPrime(8));
        Assertions.assertFalse(primeCalculator.isPrime(1));

    }


    @Test
    void testGetListOfAllNumbersUntil() {
        primeCalculator.getListOfAllNumbersUntil(2,10);
        List<Integer> primesUntil10 = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9);
        Assertions.assertEquals(primesUntil10,primeCalculator.getListOfAllNumbersUntil(2,10));
    }

    @Test
    void TestGetAllPrimesUntil() {
        primeCalculator.getAllPrimesUntil(10);
        List<Integer> primesUntil10 = Arrays.asList(2,3,5,7);
        Assertions.assertEquals(primesUntil10,primeCalculator.getAllPrimesUntil(10));
    }

}
