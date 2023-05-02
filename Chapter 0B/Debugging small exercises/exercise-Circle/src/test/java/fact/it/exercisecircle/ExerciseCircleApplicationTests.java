package fact.it.exercisecircle;

import fact.it.exercisecircle.model.Circle;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ExerciseCircleApplicationTests {

    /**
     * Test of constructor and getters, of class Circle.
     */
    @Test
    public void testConstructorWithoutParameterAndGetters() {
        Circle circle = new Circle();
        assertEquals(0, circle.getRadius(),0.01);
    }
    /**
     * Test of constructor and getters, of class Circle.
     */
    @Test
    public void testConstructorWithParameterAndGetters() {
        Circle circle = new Circle(0.5);
        assertEquals(0.5, circle.getRadius(),0.01);
    }

    /**
     * Test of setRadius method, of class Circle.
     */
    @Test
    public void testSetRadius() {
        Circle circle = new Circle(0.5);
        circle.setRadius(1.5);
        assertEquals(1.5, circle.getRadius(),0.01);
    }

    /**
     * Test of enlargeRadius method, of class Circle.
     */
    @Test
    public void testEnlargeRadius() {
        Circle circle = new Circle(0.5);
        circle.enlargeRadius(0.3);
        assertEquals(0.8, circle.getRadius(),0.01);
    }

    /**
     * Test of getArea method, of class Circle.
     */
    @Test
    public void testGetArea() {
        Circle circle = new Circle(0.5);
        assertEquals(0.79, circle.getArea(),0.01);

    }

    /**
     * Test of getCircumference method, of class Circle.
     */
    @Test
    public void testGetCircumference() {
        Circle circle = new Circle(0.5);
        assertEquals(3.14, circle.getCircumference(),0.01);
    }

}
