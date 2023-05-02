package fact.it.exercisepatient;
import org.junit.jupiter.api.Test;
import fact.it.exercisepatient.model.Person;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {

    @Test
    public void testConstructorsGetters() {
        Person z = new Person("Jan");
        assertEquals("Jan", z.getName());
    }

    @Test
    public void testSetters() {
        Person z = new Person("Jan");
        z.setName("Piet");
        assertEquals("Piet", z.getName());
    }

    @Test
    public void testToString() {
        Person z = new Person("Jan");
        z.setName("Piet");
        assertEquals("Name: Piet", z.toString());
    }
}
