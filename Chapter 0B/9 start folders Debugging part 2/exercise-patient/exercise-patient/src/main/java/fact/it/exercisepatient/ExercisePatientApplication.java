package fact.it.exercisepatient;

import fact.it.exercisepatient.model.Consultation;
import fact.it.exercisepatient.model.Doctor;
import fact.it.exercisepatient.model.Patient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExercisePatientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExercisePatientApplication.class, args);
        Doctor doctor = new Doctor("Cardiologist", "Leo Lebon");
        Patient patient = new Patient("750510 105M16","Tom Verlaet");
        Consultation consultation = new Consultation(doctor, patient);
        System.out.println(consultation);
        System.exit(0); }

}
