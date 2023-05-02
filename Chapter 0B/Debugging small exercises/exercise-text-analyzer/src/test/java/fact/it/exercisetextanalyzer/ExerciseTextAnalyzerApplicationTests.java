package fact.it.exercisetextanalyzer;

import fact.it.exercisetextanalyzer.model.TextAnalyzer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.DayOfWeek;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ExerciseTextAnalyzerApplicationTests {

    @Test
    public void testConstructorAndGetters() {
        TextAnalyzer textAnalyzer = new TextAnalyzer();
        textAnalyzer.setText("we should not allow this in our school");
        assertEquals("we should not allow this in our school", textAnalyzer.getText());
    }

    @Test
    public void testPigLatin() {
        TextAnalyzer textAnalyzer = new TextAnalyzer();
        textAnalyzer.setText("we should not allow this in our school");
        assertEquals("eway houldsay otnay llowaay histay niay uroay choolsay", textAnalyzer.pigLatin());
    }

    @Test
    public void testCountLetters() {
        TextAnalyzer textAnalyzer = new TextAnalyzer();
        textAnalyzer.setText("we should not allow this in our school");
        assertEquals(31, textAnalyzer.countLetters());
    }

    @Test
    public void testCountLettersOther() {
        TextAnalyzer textAnalyzer = new TextAnalyzer();
        textAnalyzer.setText("we should not allow more than 250 students in our school");
        assertEquals(43, textAnalyzer.countLetters());
    }

    @Test
    public void testCountDigits() {
        TextAnalyzer textAnalyzer = new TextAnalyzer();
        textAnalyzer.setText("we should not allow more than 250 students in our school");
        assertEquals(3, textAnalyzer.countDigits());
    }

}
