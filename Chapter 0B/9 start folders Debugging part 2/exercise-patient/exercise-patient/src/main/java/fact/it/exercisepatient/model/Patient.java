package fact.it.exercisepatient.model;

public class Patient extends Person {
    private String nationalNumber;

    public Patient() {
    }

    public Patient(String nationalNumber) {
        this.nationalNumber = nationalNumber;
    }

    public Patient(String name, String nationalNumber) {
        this.nationalNumber = nationalNumber;
    }

    public String getNationalNumber() {
        return nationalNumber;
    }

    public void setNationalNumber(String nationalNumber) {
        this.nationalNumber = nationalNumber;
    }

    @Override
    public String toString() {
        return super.toString() + " (national number: " + nationalNumber+")";
    }
}
