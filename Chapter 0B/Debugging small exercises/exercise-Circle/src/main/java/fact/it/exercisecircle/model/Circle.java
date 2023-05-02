package fact.it.exercisecircle.model;

public class Circle {
    private int radius;

    public Circle() {
        radius = 1;
    }

    public Circle(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void enlargeRadius(double amount) {
        this.radius += amount;
    }

    public double getArea() {
        double area =  Math.PI * radius * radius;
        return Math.round(area * 100) / 100;
    }

    public double getCircumFerence() {
        double circumference = 2 * Math.PI * radius;
        return Math.round(circumference * 100) / 100;
    }
}
