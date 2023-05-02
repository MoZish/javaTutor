package fact.it.exerciserenovation.model;

public class Renovationproject {

    private double length, width, height;
    private boolean ceilingIncluded;
    private int numberOfLayers;

    public Renovationproject(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public boolean isCeilingIncluded() {
        return ceilingIncluded;
    }

    public void setCeilingIncluded(boolean ceilingIncluded) {
        this.ceilingIncluded = ceilingIncluded;
    }

    public int getNumberOfLayers() {
        return numberOfLayers;
    }

    public void setNumberOfLayers(int numberOfLayers) {
        this.numberOfLayers = numberOfLayers;
    }

    public double getAmountOfPaintInLitres() {
        double area = ((length + width * 2) * height) + (ceilingIncluded ? 0 : length * width);
        return (area * numberOfLayers) / 10.0;
    }
}
