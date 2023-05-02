package fact.it.exerciserandomgenerator;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExerciseRandomGeneratorApplication {

    public static void main(String[] args) {

        SpringApplication.run(ExerciseRandomGeneratorApplication.class, args);
        System.out.println("Random numbers between -50 and 50");
        RandomGenerator randomGenerator = new RandomGenerator(-50, 101);
        for (int i = 0; i < 10; i++) {
            System.out.print(randomGenerator.getRandom() " ");
        }
        System.out.println();
        System.exit(0);
    }

}
