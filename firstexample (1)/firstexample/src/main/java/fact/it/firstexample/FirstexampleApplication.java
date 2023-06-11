package fact.it.firstexample;

import fact.it.firstexample.model.Language;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstexampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstexampleApplication.class, args);
        Language language = new Language("Java");
        System.out.println("Your new programming language = "+ language.getName());
    }

}
