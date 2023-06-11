package fact.it.startproject.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    @Test
    void testToStringAparment() {
        Apartment apartment = new Apartment();
        apartment.setFloor(1);
        apartment.setCode("APT1");
        apartment.setSurface(12.1);

        assertEquals("Apartment (APT1) on floor: 1 with 0 contract(s)", apartment.toString());
    }

    @Test
    void testToStringTownHouse() {
        House house = new House();
        house.setCode("HS1");
        house.setSurface(20.5);
        house.setTownhouse(true);

        assertEquals("Townhouse (HS1) with 0 contract(s)", house.toString());
    }

    @Test
    void testToStringDetachedHouse() {
        House house = new House();
        house.setCode("HS2");
        house.setSurface(25);
        house.setTownhouse(false);

        assertEquals("Detached house (HS2) with 0 contract(s)", house.toString());
    }
}