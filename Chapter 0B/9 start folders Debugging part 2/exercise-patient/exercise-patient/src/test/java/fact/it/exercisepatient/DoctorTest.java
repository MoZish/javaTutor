package fact.it.exercisepatient;
import fact.it.exercisepatient.model.Doctor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class DoctorTest {

    @Test
    public void testConstructorsGetters() {
        Doctor z = new Doctor("Jan", "Cardiologist");
        assertEquals("Jan", z.getName());
        assertEquals("Cardiologist", z.getSpecialization());
        assertEquals(0.0, z.getHonorarium(), 0.1);

        Doctor d = new Doctor("Jan2", "Orthopedist", 120.5);
        assertEquals("Jan2", d.getName());
        assertEquals("Orthopedist", d.getSpecialization());
        assertEquals(120.5, d.getHonorarium(), 0.1);

    }

    @Test
    public void testSetters() {
        Doctor d = new Doctor("Jan", "Gynaecologist");
        d.setName("Piet");
        d.setHonorarium(200.5);
        d.setSpecialization("Oncology");

        assertEquals("Piet", d.getName());
        assertEquals("Oncology", d.getSpecialization());
        assertEquals(200.5, d.getHonorarium(), 0.1);
    }

    @Test
    public void testToString() {
        Doctor d = new Doctor("Jan", "Gynaecologist");
        d.setHonorarium(200.5);
        assertEquals("Dr. Jan, Gynaecologist", d.toString());
    }

    @Test
    public void testToString2() {
        Doctor d = new Doctor("Piet", "Gynaecologist");
        d.setHonorarium(2200.5);
        assertEquals("Dr. Piet, Gynaecologist", d.toString());
    }
}
