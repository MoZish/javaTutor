package fact.it.exercisepatient.model;

public class Doctor extends Patient{
    private String specialization;
    private double honorarium;

    public Doctor() {
    }

    public Doctor(String name, String specialization) {
        this.specialization = specialization;
    }


    public Doctor(String name, String specialization, double honorarium) {
        this.specialization = specialization;
        this.honorarium = honorarium;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public double getHonorarium() {
        return honorarium;
    }

    public void setHonorarium(double honorarium) {
        this.honorarium = honorarium;
    }

    @Override
    public String toString() {
        return "Dr. " + getName() + ", " + specialization;
    }

}
