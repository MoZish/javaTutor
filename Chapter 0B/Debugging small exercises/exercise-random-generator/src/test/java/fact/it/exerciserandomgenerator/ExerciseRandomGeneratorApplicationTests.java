package fact.it.exerciserandomgenerator;

import fact.it.exerciserandomgenerator.model.RandomGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ExerciseRandomGeneratorApplicationTests {

    @Test
    public void testConstructorWithoutParametersAndGetters(){
        RandomGenerator r = new RandomGenerator();
        assertEquals(1, r.getSmallest());
        assertEquals(5, r.getNumber());
    }

    @Test
    public void testConstructorWithParametersAndGetters(){
        RandomGenerator r = new RandomGenerator(7, 10);
        assertEquals(7, r.getSmallest());
        assertEquals(10, r.getNumber());
    }


    @Test
    public void testSetters() {
        RandomGenerator r = new RandomGenerator(7, 10);
        r.setSmallest(12);
        assertEquals(12, r.getSmallest());
        r.setNumber(75);
        assertEquals(75, r.getNumber());
    }

    /**
     * Test of getRandom method, of class RandomGenerator.
     */
    @Test
    public void testGetRandom() {
        RandomGenerator r = new RandomGenerator(10, 7);
        for (int i = 0; i < 500; i++) {
            assertTrue(r.getRandom() < 18);
            assertTrue(r.getRandom()>=10);
        }
    }


}
