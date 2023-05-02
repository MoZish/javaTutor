package fact.it.exercisepatient.model;

import java.time.LocalDate;

public class Consultation {
    private Doctor doctor;
    private Person patient;


    public Consultation(Doctor doctor, Person patient) {
        this.doctor = doctor;
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Person getPatient() {
        return patient;
    }

    public void setPatient(Person patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "Doctor: " + doctor +  "\nPatient: " + patient + "\nConsultation: " + LocalDate.now();
    }

}
