package fact.it.exercisedateanalyzer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExerciseDateAnalyzerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExerciseDateAnalyzerApplication.class, args);
        DateAnalyzer dateAnalyzer = new DateAnalyzer("15/6/2001");

        System.out.println("You were born on: " + dateAnalyzer.getDate() );
        System.out.println("Day of the month: " + dateAnalyzer.getNumberedDayOfTheMonth() );
        System.out.println("Day of year: " + dateAnalyzer.getNumberedDayOfTheYear() );
        System.out.println("Weekday: " + dateAnalyzer.getDayOfWeek());
        System.out.println("Month: " + dateAnalyzer.getMonth());
        System.out.println("On that day you were 100 days old: " + dateAnalyzer.get10DaysOld() );
        System.out.println("On that day you were 10 months old: " + dateAnalyzer.get100MonthsOld() );
        System.exit(0);

    }

}
