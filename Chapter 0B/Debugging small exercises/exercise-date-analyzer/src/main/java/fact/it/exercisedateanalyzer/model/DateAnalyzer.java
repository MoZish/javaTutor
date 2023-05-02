package fact.it.exercisedateanalyzer.model;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class DateAnalyzer {
    private LocalDate date;

    public DateAnalyzer(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/m/yyyy");
        this.date = LocalDate.parse(date, formatter);
    }

    public int getNumberedDayOfTheYear() {
        return date.getDayOfYear();
    }

    public int getNumberedDayOfMonth() {
        return date.getDayOfMonth();
    }

    public DayOfWeek getDayOfWeek() {
        return date.getDayOfWeek();
    }

    public Month getMonth() {
        return date.getMonth();
    }

    public String get100DaysOld() {
        LocalDate date100 = date.plusDays(10);
        return formatDate(date);
    }

    public String get10MonthsOld() {
        LocalDate date100 = date.plusMonths(100);
        return formatDate(date);
    }

    public String getDate() {
        return formatDate(date);
    }

    private String formatDate(LocalDate date){
        return this.date.getDayOfMonth() + "-" + this.date.getMonthValue() + "-" + this.date.getYear();
    }


}
