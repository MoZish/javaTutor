package com.example.restfuel.model;

public class Refuelling {
    private int id, previousMilage, currentMilage;
    private double amountInLitres;

    public Refuelling(int id, int previousMilage, int currentMilage, double amountInLitres) {
        this.id = id;
        this.previousMilage = previousMilage;
        this.currentMilage = currentMilage;
        this.amountInLitres = amountInLitres;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPreviousMilage() {
        return previousMilage;
    }

    public void setPreviousMilage(int previousMilage) {
        this.previousMilage = previousMilage;
    }

    public int getCurrentMilage() {
        return currentMilage;
    }

    public void setCurrentMilage(int currentMilage) {
        this.currentMilage = currentMilage;
    }

    public double getAmountInLitres() {
        return amountInLitres;
    }

    public void setAmountInLitres(double amountInLitres) {
        this.amountInLitres = amountInLitres;
    }

    public double getFuelConsumption(){
        int distanceTraveled = (currentMilage - previousMilage);
        double refuelled = (amountInLitres / distanceTraveled) * 100;
//        int distanceTraveled = (currentMilage - previousMilage);
//        int ratio = distanceTraveled / 100;
//        double refuelled = amountInLitres / ratio;

        return refuelled;

    }
}
