package fact.it.exerciserenovation;

import fact.it.exerciserenovation.model.Renovationproject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ExerciseRenovationApplicationTests {

    /**
     * Test of constructor en getters
     */
    @Test
    public void testConstructorAndGetters() {

        Renovationproject project = new Renovationproject(4.1, 3, 2.5);
        assertEquals(4.1, project.getLength());
        assertEquals(3, project.getWidth());
        assertEquals(2.5, project.getHeight());

    }

    /**
     * Test of isPlafond method, of class Renovationproject.
     */
    @Test
    public void testIsCeiling() {
        Renovationproject project = new Renovationproject(4.1, 3, 2.5);
        project.setCeilingIncluded(true);
        assertTrue(project.isCeilingIncluded());
    }

    /**
     * Test of setAantalLagen method, of class Renovationproject.
     */
    @Test
    public void testSetNumberOfLayers() {
        Renovationproject project = new Renovationproject(4.1, 3, 2.5);
        project.setNumberOfLayers(2);
        assertEquals(2, project.getNumberOfLayers());
    }

    /**
     * Test of setLengte method, of class Renovationproject.
     */
    @Test
    public void testSetLength() {
        Renovationproject project = new Renovationproject(4.1, 3, 2.5);
        project.setLength(5.8);
        assertEquals(5.8, project.getLength());
    }

    /**
     * Test of setBreedte method, of class Renovationproject.
     */
    @Test
    public void testSetWidth() {
        Renovationproject project = new Renovationproject(4.1, 3, 2.5);
        project.setWidth(4.3);
        assertEquals(4.3, project.getWidth());
    }

    /**
     * Test of setHoogte method, of class Renovationproject.
     */
    @Test
    public void testSetHeight() {
        Renovationproject project = new Renovationproject(4.1, 3, 2.5);
        project.setHeight(2.0);
        assertEquals(2.0, project.getHeight());
    }

    /**
     * Test of getLiterVerf method, of class Renovationproject.
     */
    @Test
    public void testGetAmountOfPaintInLitres() {
        Renovationproject project = new Renovationproject(4.1, 3, 2.5);
        project.setCeilingIncluded(false);
        project.setNumberOfLayers(2);
        assertEquals(7.1, project.getAmountOfPaintInLitres());
    }

}

