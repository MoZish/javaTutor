package fact.it.lambda.primecalculator;
//
//•	The method getListOfAllNumbersUntil creates a list of integers starting from the start-value until the end-value (inclusive).
//  Tip: use the InStream-class which has an interesting static method called “range(start, end)”. Be careful! This method
//  generates a list of integers (the end-value exclusive) as an InStream-object. To make a list of integers, you need
//  to use the method “boxed()” and the “toList()” method
//
//        •	The method isPrime has to implement the prime logic: if a number is a prime, this method returns true.
//        In all other cases this method returns false. This method makes use of the previous method…
//
//        •	The method getAllPrimesUntil generates all prime numbers starting from 0 until the value of the number-value
//        (inclusive). This method makes use of the previous methods…


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeCalculator {
    public List<Integer> getListOfAllNumbersUntil(Integer start, Integer end){
        return IntStream.range(start,end).boxed().toList();
    }
    public boolean isPrime(Integer number) {
        if (number < 2){
            return false;
        }

        return getListOfAllNumbersUntil(2, 10).stream().filter(n -> n != 1 && n != number).noneMatch(n -> number % n == 0);
    }
    public List<Integer> getAllPrimesUntil(Integer number) {
        return getListOfAllNumbersUntil(0,number).stream().filter(this::isPrime).collect(Collectors.toList());
    }
}
