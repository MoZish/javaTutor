package fact.it.examplebicycledebugging;

import fact.it.examplebicycledebugging.model.Bicycle;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BicycleTest {

    @Test
    public void testNoArgConstructorAndGetters() {
        Bicycle myBike = new Bicycle();
        assertEquals("not defined", myBike.getType());
        assertEquals(0, myBike.getYear());
        assertEquals(0.0, myBike.getRentalPrice(), 0.01);
    }

    @Test
    public void testConstructorAndGetters() {
        Bicycle myBike = new Bicycle("ladies large bicycle", 2018);
        assertEquals("ladies large bicycle", myBike.getType());
        assertEquals(2018, myBike.getYear());
        assertEquals(0.0, myBike.getRentalPrice(), 0.01);
    }

    @Test
    public void testSetType() {
        Bicycle myBike = new Bicycle();
        myBike.setType("ladies large bicycle");
        assertEquals("ladies large bicycle", myBike.getType());
    }

    @Test
    public void testSetYear() {
        Bicycle myBike = new Bicycle();
        myBike.setYear(2016);
        assertEquals(2016, myBike.getYear());
    }

    @Test
    public void testSetRentalPrice() {
        Bicycle myBike = new Bicycle();
        myBike.setRentalPrice(5.5);
        assertEquals(5.5, myBike.getRentalPrice(), 0.01);
    }

    @Test
    public void testIncreasePrice() {
        Bicycle myBike = new Bicycle();
        myBike.setRentalPrice(4.5);
        myBike.increasePrice();
        assertEquals(5.0, myBike.getRentalPrice(), 0.01);
    }

    @Test
    public void testIncreasePrice2() {
        Bicycle myBike = new Bicycle();
        myBike.setRentalPrice(4.5);
        myBike.increasePrice(0.3);
        assertEquals(4.8, myBike.getRentalPrice(), 0.01);
    }

    @Test
    public void testGetPricePerYearWithYearGreaterThan2014() {
        Bicycle myBike = new Bicycle();
        myBike.setRentalPrice(4.5);
        myBike.setYear(2016);
        assertEquals(54.0, myBike.getPricePerYear(), 0.01);
    }

    @Test
    public void testGetPricePerYearWithYearSmallerThan2014() {
        Bicycle myBike = new Bicycle();
        myBike.setRentalPrice(4.5);
        myBike.setYear(2013);
        assertEquals(51.3, myBike.getPricePerYear(), 0.01);
    }

    @Test
    public void testGetPricePerYearWithYearEqualTo2014() {
        Bicycle myBike = new Bicycle();
        myBike.setRentalPrice(4.5);
        myBike.setYear(2014);
        assertEquals(54.0, myBike.getPricePerYear(), 0.01);
    }

    @Test
    public void testGetFrameSizes() {
        // M from 0 till 149 cm
        // L from 150 till 189 cm
        // XL from 190 cm
        Bicycle myBike = new Bicycle();
        assertEquals("M", myBike.getFrameSize(149));
        assertEquals("L", myBike.getFrameSize(150));
        assertEquals("L", myBike.getFrameSize(189));
        assertEquals("XL", myBike.getFrameSize(190));
        assertEquals("XL", myBike.getFrameSize(191));
    }

    @Test
    public void testTirePressure() {
        // Ideal tire pressure = weight (in kg) / 10
        // There is ALWAYS a minimum pressure = 6 (bar)
        // There is ALWAYS a maximum pressure = 9 (bar)
        Bicycle myBike = new Bicycle();
        assertEquals(6, myBike.getTirePressure(59));
        assertEquals(6, myBike.getTirePressure(60));
        assertEquals(6.1, myBike.getTirePressure(61));
        assertEquals(6.9, myBike.getTirePressure(69));
        assertEquals(7, myBike.getTirePressure(70));
        assertEquals(7.1, myBike.getTirePressure(71));
        assertEquals(7.9, myBike.getTirePressure(79));
        assertEquals(8, myBike.getTirePressure(80));
        assertEquals(8.1, myBike.getTirePressure(81));
        assertEquals(8.9, myBike.getTirePressure(89));
        assertEquals(9, myBike.getTirePressure(91));
        assertEquals(9, myBike.getTirePressure(99));
        assertEquals(9, myBike.getTirePressure(100));
    }

    @Test
    public void testhowManyPumps() {
        // Every pump = 0.1 bar.
        // when age < 40, no rest is required.
        // when age is >=40 and <50, after each 30 pumps a rest is required.
        // when age is >= 50, after each 20 pumps a rest is required.
        // when age is >= 60, after each 10 pumps a rest is required.
        Bicycle myBike = new Bicycle();
        // age < 40
        assertEquals("60P", myBike.howManyPumps(6, 39));
        assertEquals("71P", myBike.howManyPumps(7.1, 39));
        assertEquals("85P", myBike.howManyPumps(8.5, 39));
        // 40 <= age < 50
        assertEquals("30P,30P", myBike.howManyPumps(6, 40));
        assertEquals("30P,30P,11P", myBike.howManyPumps(7.1, 40));
        assertEquals("30P,30P,30P", myBike.howManyPumps(9, 40));
        assertEquals("30P,30P", myBike.howManyPumps(6, 49));
        assertEquals("30P,30P,11P", myBike.howManyPumps(7.1, 49));
        assertEquals("30P,30P,30P", myBike.howManyPumps(9, 49));
        // 50 <= age < 60
        assertEquals("20P,20P,20P", myBike.howManyPumps(6, 50));
        assertEquals("20P,20P,20P,11P", myBike.howManyPumps(7.1, 50));
        assertEquals("20P,20P,20P,20P,10P", myBike.howManyPumps(9, 50));
        assertEquals("20P,20P,20P", myBike.howManyPumps(6, 59));
        assertEquals("20P,20P,20P,11P", myBike.howManyPumps(7.1, 59));
        assertEquals("20P,20P,20P,20P,10P", myBike.howManyPumps(9, 59));
        // age >= 60
        assertEquals("10P,10P,10P,10P,10P,10P", myBike.howManyPumps(6, 60));
        assertEquals("10P,10P,10P,10P,10P,10P,10P,1P", myBike.howManyPumps(7.1, 60));
        assertEquals("10P,10P,10P,10P,10P,10P,10P,10P,10P", myBike.howManyPumps(9, 60));
    }

}
