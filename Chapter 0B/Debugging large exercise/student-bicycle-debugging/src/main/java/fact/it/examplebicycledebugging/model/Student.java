package fact.it.examplebicycledebugging.model;

import java.time.LocalDate;
import java.time.Period;

public class Student {
    private String rnumber, firstname, surname;
    private boolean foreigner;
    private int weight; // in kg
    private int length; // in cm
    private LocalDate birthday;

    public Student() {
    }

    public Student(String rnumber, String surname, String firstname) {
        this.rnumber = rnumber;
        this.firstname = firstname;
        this.surname = surname;
    }

    public String getRnumber() {
        return rnumber;
    }

    public void setRnumber(String rnumber) {
        this.rnumber = rnumber;
    }

    public String getFirstName() {
        return firstname;
    }

    public void setFirstName(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public boolean isForeigner() {
        return foreigner;
    }

    public void setForeigner(boolean foreigner) {
        this.foreigner = foreigner;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthDay(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getAge() {
        if (birthday != null) {
            LocalDate todayDate = LocalDate.now();
            return Period.between(todayDate, birthday).getYears();
        } else {
            return 0;
        }

    }

    public String getEmailAddress() {
        if (rnumber != null) {
            return rnumber + "@student.thomasmore.be ";
        } else {
            return null;
        }
    }

    public String getInitials() {
        if firstname != null ||surname != null {  // dubbele haakjes verwijderen && vervangen door ||
            return firstname.charAt(0) + surname.substring(0, 2);
        } else {
            return null;
        }

    }  //  charAt(0) vervangen door charAt(1)

    public String getFullName() {
        if ((firstname != null) && (surname != null)) {
            return firstname + " " + surname.toUpperCase() + " (" + getInitials() + ")";
        } else {
            return null;
        }

    }


}
