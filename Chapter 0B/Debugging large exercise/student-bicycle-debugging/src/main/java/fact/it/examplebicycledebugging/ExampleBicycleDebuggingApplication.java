package fact.it.examplebicycledebugging;


import fact.it.examplebicycledebugging.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.SocketOption;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class ExampleBicycleDebuggingApplication {

    public static void main(String[] args) {

        SpringApplication.run(ExampleBicycleDebuggingApplication.class, args);

        // BICYCLE -----

        Bicycle myBicycle = new Bicycle;
        myBicycle.setType("Men's bicycle large");
        myBicycle.setYear(2016);
        myBicycle.setRentalPrice(4.5);

        System.out.println();
        System.out.println("-- NEW BICICLE");
        System.out.println("You created a Bicycle-object with the following values:");
        System.out.println("The type of your bicycle is: " + myBicycle.getType());
        System.out.println("The year of your bicycle is: " + myBicycle.getYear());
        System.out.println("The rental price of your bicycle is: " + myBicycle.getRentalPrice());

        myBicycle.increasePrice();
        System.out.println("After increasing the price, the rental price is now: " + myBicycle.getRentalPrice());
        System.out.println("And the price per year is: " + myBicycle.getPricePerYear());

        // STUDENT -----

        Student myStudent = new Student("r01234567", "Piet", "Plessers");
        myStudent.setForeigner(True);
        myStudent.setWeight(75);
        LocalDate hisBirthday = LocalDate.of(1980,01,01);
        myStudent.setBirthDay(hisBirthday);
        myStudent.setLength(175);

        System.out.println();
        System.out.println("-- NEW STUDENT");
        System.out.println("You created a Student-object with the following values:");
        System.out.println("Full name: " + myStudent.getFullName());
        System.out.println("Email: " + myStudent.getEmailAddres());

        System.out.println("Weight: " + myStudent.getWeight() + "kg");
        System.out.println("Birthday: " + myStudent.getBirthday());
        System.out.println("Age: " + myStudent.getAge());

        // STUDENT -----
        System.out.println();
        System.out.println("-- STUDENT RENTS BICYCLE");
        System.out.println("This student needs following frame size: " + myBicycle.getFrameSize(myStudent.getLength()));
        System.out.println("The tyre pressure should be " + myBicycle.getTirePressure(myStudent.getWeight()) + " bar.");
        System.out.println("Getting the tire pressure correct: " + myBicycle.howManyPumps(myBicycle.getTirePressure(myStudent.getWeight()), myStudent.getAge()));

        System.exit(0);
    }

}
