package fact.it.exercisecourse;

import fact.it.exercisecourse.model.Course;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ExerciseCourseApplicationTests {

    /**
     * Test of constructor met 1 parameter en getters
     */
    @Test
    public void testConstructorAndGetters() {

        Course course = new Course("Java initiatie");
        assertEquals("Java initiatie", course.getName());
    }

    /**
     * Test of constructor met 2 parameters en getters
     */
    @Test
    public void testConstructorAndGetters1() {

        Course course = new Course("Java initiatie", 4);
        assertEquals("Java initiatie", course.getName());
        assertEquals(4, course.getNumberOfDays());
    }

    /**
     * Test of setNaam method, of class Course.
     */
    @Test
    public void testSetName() {
        Course course = new Course("Java initiatie", 4);
        course.setName("Python inleiding");
        assertEquals("Python inleiding", course.getName());
    }

    /**
     * Test of setLocatie method, of class Course.
     */
    @Test
    public void testSetLocation() {
        Course course = new Course("Java initiatie", 4);
        course.setLocation("Leuven");
        assertEquals("Leuven", course.getLocation());
    }

    /**
     * Test of setAantalDagen method, of class Course.
     */
    @Test
    public void testSetNumberOfDays() {
        Course course = new Course("Java initiatie", 4);
        course.setNumberOfDays(6);
        assertEquals(6, course.getNumberOfDays());
    }

    /**
     * Test of isWekelijks method, of class Course.
     */
    @Test
    public void testIsWeekly() {
        Course course = new Course("Java initiatie", 4);
        course.setWeekly(true);
        assertEquals(true, course.isWeekly());
    }

    /**
     * Test of setStartDatum method, of class Course.
     */
    @Test
    public void testSetStartDate() {
        Course course = new Course("Java initiatie", 4);
        course.setStartDate(LocalDate.of(2020,10,13));
        assertEquals(2020, course.getStartDate().getYear());
        assertEquals(10, course.getStartDate().getMonthValue());
        assertEquals(13, course.getStartDate().getDayOfMonth());
    }


}
