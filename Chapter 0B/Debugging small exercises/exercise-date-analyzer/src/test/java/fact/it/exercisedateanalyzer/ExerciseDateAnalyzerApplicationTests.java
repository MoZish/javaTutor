package fact.it.exercisedateanalyzer;

import fact.it.exercisedateanalyzer.model.DateAnalyzer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.DayOfWeek;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class ExerciseDateAnalyzerApplicationTests {


    @Test
    public void testConstructorAndGetters() {
        DateAnalyzer dateAnalyzer = new DateAnalyzer("7/1/1998");
        assertEquals("7-1-1998", dateAnalyzer.getDate());
    }

    @Test
    public void testGetNumberedDayOfTheYea() {
        DateAnalyzer dateAnalyzer = new DateAnalyzer("7/5/1998");
        assertEquals(127, dateAnalyzer.getNumberedDayOfTheYear());
    }

    @Test
    public void testGetNumberedDayOfTheMonth() {
        DateAnalyzer dateAnalyzer = new DateAnalyzer("7/1/1998");
        assertEquals(7, dateAnalyzer.getNumberedDayOfTheMonth());
    }

    @Test
    public void testGetDayOfWee() {
        DateAnalyzer dateAnalyzer = new DateAnalyzer("7/1/1998");
        assertEquals(DayOfWeek.WEDNESDAY, dateAnalyzer.getDayOfWeek());
    }


    @Test
    public void testGetMonth() {
        DateAnalyzer dateAnalyzer = new DateAnalyzer("7/1/1998");
        assertEquals(Month.JANUARY, dateAnalyzer.getMonth());
    }


    @Test
    public void testGet100DaysOld() {
        DateAnalyzer dateAnalyzer = new DateAnalyzer("7/1/1998");
        assertEquals("17-4-1998", dateAnalyzer.get100DaysOld());
    }


    @Test
    public void testGet10MonthsOld() {
        DateAnalyzer dateAnalyzer = new DateAnalyzer("7/1/1998");
        assertEquals("7-11-1998", dateAnalyzer.get10MonthsOld());
    }


    @Test
    public void testGetNumberedDayOfTheYear() {
        DateAnalyzer dateAnalyzer = new DateAnalyzer("7/12/1999");
        assertEquals(341, dateAnalyzer.getNumberedDayOfTheYear());
    }


    @Test
    public void testGetNumberedDayOfTheMonthOther() {
        DateAnalyzer dateAnalyzer = new DateAnalyzer("7/12/1999");
        assertEquals(7, dateAnalyzer.getNumberedDayOfTheMonth());
    }


    @Test
    public void testGetDayOfWeek() {
        DateAnalyzer dateAnalyzer = new DateAnalyzer("7/12/1999");
        assertEquals(DayOfWeek.TUESDAY, dateAnalyzer.getDayOfWeek());
    }


    @Test
    public void testGetMonthOther() {
        DateAnalyzer dateAnalyzer = new DateAnalyzer("7/12/1998");
        assertEquals(Month.DECEMBER, dateAnalyzer.getMonth());
    }


    @Test
    public void testGet100DaysOldOther() {
        DateAnalyzer dateAnalyzer = new DateAnalyzer("7/12/1999");
        assertEquals("16-3-2000", dateAnalyzer.get100DaysOld());
    }

    @Test
    public void testGet10MonthsOldOther() {
        DateAnalyzer dateAnalyzer = new DateAnalyzer("17/12/1999");
        assertEquals("17-10-2000", dateAnalyzer.get10MonthsOld());
    }


}
