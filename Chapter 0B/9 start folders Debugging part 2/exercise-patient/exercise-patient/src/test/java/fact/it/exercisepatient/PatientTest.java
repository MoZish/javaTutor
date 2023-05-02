package fact.it.exercisepatient;
import fact.it.exercisepatient.model.Patient;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class PatientTest {
    @Test
    public void testConstructorsGetters() {
        Patient z = new Patient("54897");
        assertEquals(null, z.getName());
        assertEquals("54897", z.getNationalNumber());

        Patient p2 = new Patient("Jan", "654123");
        assertEquals("Jan", p2.getName());
        assertEquals("654123", p2.getNationalNumber());
    }

    @Test
    public void testSetters() {
        Patient p = new Patient("Jan", "654123");
        p.setName("Piet");
        p.setNationalNumber("654987");
        assertEquals("Piet", p.getName());
        assertEquals("654987", p.getNationalNumber());
    }

    @Test
    public void testToString() {
        Patient p = new Patient("Jan", "654123");
        assertEquals("Name: Jan (national number: 654123)", p.toString());
    }

    @Test
    public void testToString2() {
        Patient p = new Patient("Piet", "147852");
        assertEquals("Name: Piet (national number: 147852)", p.toString());
    }

}
