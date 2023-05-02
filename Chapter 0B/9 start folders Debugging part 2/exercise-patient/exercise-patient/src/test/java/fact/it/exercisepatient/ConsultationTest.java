package fact.it.exercisepatient;

import fact.it.exercisepatient.model.Doctor;
import fact.it.exercisepatient.model.Patient;
import fact.it.exercisepatient.model.Consultation;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConsultationTest {

    @Test
    public void testConstructorsGetters() {
        Doctor z = new Doctor("Jan", "Surgeon");
        Patient p = new Patient("Jan", "654123");
        Consultation r = new Consultation(z, p);
        assertEquals(z, r.getDoctor());
        assertEquals(p, r.getPatient());
    }

    @Test
    public void testSetters() {
        Doctor z = new Doctor("Piet", "Cardiologist");
        Patient p = new Patient("Piet", "654123");
        Consultation r = new Consultation(z, p);
        Doctor z2 = new Doctor("Piet", "Cardiologist");
        Patient p2 = new Patient("Piet", "654123");
        r.setDoctor(z2);
        r.setPatient(p2);
        assertEquals(z2, r.getDoctor());
        assertEquals(p2, r.getPatient());
    }


    @Test
    public void testToString() {
        Doctor z = new Doctor("Piet", "Cardiologist");
        Patient p = new Patient("Tom", "654897");
        Consultation r = new Consultation(z, p);
        assertEquals("Doctor: Dr. Piet, Cardiologist\nPatient: Name: Tom (national number: 654897)\nConsultation: "+ LocalDate.now(), r.toString());
    }
}

