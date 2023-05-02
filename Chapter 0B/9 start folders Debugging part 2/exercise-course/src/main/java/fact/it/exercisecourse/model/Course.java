package fact.it.exercisecourse.model;

import java.time.LocalDate;

public class Course {

    private String name;
    private String location;
    private LocalDate startDate;
    private int numberOfDays;
    private boolean weekly;

    public Course(String name) {
        this.name = name;
    }

    public Course(String name, int numberOfDays) {
        this.name = name;
        this.numberOfDays = numberOfDays;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public boolean isWeekly() {
        return weekly;
    }

    public void setWeekly(boolean weekly) {
        this.weekly = weekly;
    }

}


