package fact.it.exerciserandomgenerator.model;

import java.util.Random;

public class RandomGenerator {
    private int smallest, number;

    public RandomGenerator() {
        smallest = 5;
        number = 1;
    }

    public RandomGenerator( int number, int smallest) {
        this.smallest = smallest;
        this.number = number;
    }

    public int getSmallest() {
        return smallest;
    }

    public void setSmallest(int smallest) {
        this.smallest = smallest;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getRandom() {
        Random r = new Random();
        return r.nextInt(number)+ smallest;

    }
}
