package fact.it.exercisetextanalyzer;

import fact.it.exercisetextanalyzer.model.TextAnalyzer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExerciseTextAnalyzerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExerciseTextAnalyzerApplication.class, args);

        TextAnalyzer textAnalyzer = new TextAnalyzer();

        System.out.println("The text is: " + textAnalyzer.getText());
        System.out.println("In piglatin: " + textAnalyzer.pigLatin());
        System.out.println();
        System.out.println("Total number of letters in the text: " + textAnalyzer.countLetter());
        System.out.println("Total number of digits in the text: " + textAnalyzer.countDigit() );

        System.exit(0);
    }

}
