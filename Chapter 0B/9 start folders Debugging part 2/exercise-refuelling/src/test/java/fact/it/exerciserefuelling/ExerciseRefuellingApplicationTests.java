package fact.it.exerciserefuelling;

import fact.it.exerciserefuelling.model.Refuelling;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ExerciseRefuellingApplicationTests {


    /**
     * Test of constructor en getters
     */
    @Test
    public void testConstructorAndGetters() {

        Refuelling refuelling = new Refuelling(1000, 1800, 60);
        assertEquals(1000, refuelling.getPreviousMileage());
        assertEquals(1800, refuelling.getCurrentMileage());
        assertEquals(60, refuelling.getAmountInLitres(), 0.01);

    }

    /**
     * Test of setVorigeKmstand method, of class Refuelling.
     */
    @Test
    public void testSetPreviousMileage() {
        Refuelling refuelling = new Refuelling(1000, 1800, 60);
        refuelling.setPreviousMileage(1200);
        assertEquals(1200, refuelling.getPreviousMileage());
    }

    /**
     * Test of setHuidigeKmstand method, of class Refuelling.
     */
    @Test
    public void testSetCurrentMileage() {
        Refuelling refuelling = new Refuelling(1000, 1800, 60);
        refuelling.setCurrentMileage(1900);
        assertEquals(1900, refuelling.getCurrentMileage());
    }

    /**
     * Test of setAantalLiter method, of class Refuelling.
     */
    @Test
    public void testSetAmountInLitres() {
        Refuelling refuelling = new Refuelling(1000, 1800, 60);
        refuelling.setAmountInLitres(50.2);
        assertEquals(50.2, refuelling.getAmountInLitres(), 0.1);
    }

    /**
     * Test of getVerbruik method, of class Refuelling.
     */
    @Test
    public void testGetFuelConsumption() {
        Refuelling refuelling = new Refuelling(1000, 1800, 60);

        assertEquals(7.5, refuelling.getFuelConsumption(), 0.1);
    }

}
