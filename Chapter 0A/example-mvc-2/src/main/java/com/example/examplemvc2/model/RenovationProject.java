package com.example.examplemvc2.model;

public class RenovationProject {
    private double length, height, width;
    private int numberOfLayers;
    private boolean ceilingIncluded;

    public RenovationProject(double length, double height, double width) {
        this.length = length;
        this.height = height;
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public int getNumberOfLayers() {
        return numberOfLayers;
    }

    public void setNumberOfLayers(int numberOfLayers) {
        this.numberOfLayers = numberOfLayers;
    }

    public boolean isCeilingIncluded() {
        return ceilingIncluded;
    }

    public void setCeilingIncluded(boolean ceilingIncluded) {
        this.ceilingIncluded = ceilingIncluded;
    }

    public double getAmountOfPaintInLitres() {

        double areaOfWalls = 2 * (length + width) * height;
        double ceilingArea = length * width;
        double totalPaint = areaOfWalls;

        if (ceilingIncluded) {
            totalPaint = totalPaint + ceilingArea;
        }

        return totalPaint * numberOfLayers;

//        o	area of all walls in the room = 2 * (length + width) * height
//        o	ceiling area = length * width
//        o	per 10m² you need one litre of paint

    }
}
