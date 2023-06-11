package com.example.lambda2.model;

import java.util.List;

public class Course {
    public String name;
    public int studyPoints;


    public Course(String name, int studyPoints) {
        this.name = name;
        this.studyPoints = studyPoints;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudyPoints() {
        return studyPoints;
    }

    public void setStudyPoints(int studyPoints) {
        this.studyPoints = studyPoints;
    }
}
