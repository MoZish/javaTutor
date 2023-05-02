package fact.it.exerciserefuelling.model;

public class Refuelling {

    private int previousMileage, currentMileage;
    private double amountInLitres;

    public Refuelling(int previousMileage, int currentMileage, double aantalLiters) {
        this.previousMileage = previousMileage;
        this.currentMileage = currentMileage;
        this.amountInLitres = aantalLiters;
    }

    public int getPreviousMileage() {
        return previousMileage;
    }

    public void setPreviousMileage(int previousMileage) {
        this.previousMileage = previousMileage;
    }

    public int getCurrentMileage() {
        return currentMileage;
    }

    public void setCurrentMileage(int currentMileage) {
        this.currentMileage = currentMileage;
    }

    public double getAmountInLitres() {
        return amountInLitres;
    }

    public void setAmountInLitres(double amountInLitres) {
        this.amountInLitres = amountInLitres;
    }

    public double getFuelConsumption(){
        return Math.round((amountInLitres * 100 / (currentMileage - previousMileage))*100)/100.0;
    }

}