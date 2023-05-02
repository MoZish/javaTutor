package fact.it.examplebicycledebugging;

import fact.it.examplebicycledebugging.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootTest
public class StudentTest {
    @Test
    public void testNoArgConstructorAndGetters() {

        Student student = new Student();
        assertEquals(null, student.getRnumber());
        assertEquals(null, student.getFirstName());
        assertEquals(null, student.getSurname());
        assertEquals(false, student.isForeigner());
        assertEquals(0, student.getWeight());
        assertEquals(0, student.getAge());
        assertEquals(0, student.getLength());
        assertEquals(null, student.getBirthday());
        assertEquals(null, student.getEmailAddress());
        assertEquals(null, student.getInitials());
        assertEquals(null, student.getFullName());
    }

    @Test
    public void testConstructorAndGetters() {

        Student student = new Student("r1234567", "Piet", "Plessers");
        assertEquals("r1234567", student.getRnumber());
        assertEquals("Piet", student.getFirstName());
        assertEquals("Plessers", student.getSurname());
        assertEquals(false, student.isForeigner());
        assertEquals(0, student.getWeight());
        assertEquals(0, student.getAge());
        assertEquals(0, student.getLength());
        assertEquals(null, student.getBirthday());
        assertEquals("r1234567@student.thomasmore.be", student.getEmailAddress());
        assertEquals("PPl", student.getInitials());
        assertEquals("Piet PLESSERS (PPl)", student.getFullName());
    }

    @Test
    public void testSetRnumber() {
        Student student = new Student();
        student.setRnumber("r7654321");
        assertEquals("r7654321", student.getRnumber());
    }

    @Test
    public void testSetFirstName() {
        Student student = new Student();
        student.setFirstName("Lies");    // Name vervangen door name
        assertEquals("Lies", student.getFirstName());
    }

    @Test
    public void testSetSurname() {
        Student student = new Student();
        student.setSurname("Peeters");
        assertEquals("Peeters", student.getSurname());
    }

    @Test
    public void testSetForeigner() {
        Student student = new Student();
        student.setForeigner(true);
        assertEquals(true, student.isForeigner());
    }

    @Test
    public void testSetWeight() {
        Student student = new Student();
        student.setWeight(85);
        assertEquals(85, student.getWeight());
    }

    @Test
    public void testSetLength() {
        Student student = new Student();
        student.setLength(190);
        assertEquals(190, student.getLength());
    }

    @Test
    public void testSetBirthday() {
        Student student = new Student();
        LocalDate birthday = LocalDate.of(1980,01,10);
        student.setBirthDay(birthday);
        assertEquals(1980, student.getBirthday().getYear());
        assertEquals(1, student.getBirthday().getMonthValue());
        assertEquals(10, student.getBirthday().getDayOfMonth());
    }
    @Test
    public void testGetAge() {
        Student student = new Student();
        LocalDate birthday = LocalDate.of(1980,01,10);
        student.setBirthDay(birthday);
        assertEquals(43, student.getAge());

    }
    @Test
    public void testGetAge2() {
        Student student = new Student();
        LocalDate birthday = LocalDate.of(1994,07,12);
        student.setBirthDay(birthday);
        assertEquals(28, student.getAge());
    }

}
