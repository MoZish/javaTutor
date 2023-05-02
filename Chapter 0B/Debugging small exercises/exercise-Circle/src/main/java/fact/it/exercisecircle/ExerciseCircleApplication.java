package fact.it.exercisecircle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExerciseCircleApplication {

    public static void main(String[] args) {

        SpringApplication.run(ExerciseCircleApplication.class, args);
        Circle circle = new Circle(4.3);
        System.out.println("The circle with radius: " + circle.getRadius() + " has");
        System.out.println("area = " + circle.getArea());
        System.out.println("circumference = " + circle.getCircumference());
        System.exit(0);
    }

}
