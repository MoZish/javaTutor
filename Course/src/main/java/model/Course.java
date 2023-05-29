package model;

import java.time.LocalDate;

public class Course {
    private String name, location;
    private LocalDate startDate;
    private Integer numberOfDays;
    private boolean weekly;


    public Course(String name) {
        this.name = name;
    }
    public Course(String name, Integer numberOfDays) {
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

    public Integer getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(Integer numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public boolean isWeekly() {
        return weekly;
    }

    public void setWeekly(boolean weekly) {
        this.weekly = weekly;
    }
}
