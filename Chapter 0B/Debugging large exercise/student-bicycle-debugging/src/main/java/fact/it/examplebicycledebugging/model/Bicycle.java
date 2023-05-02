package fact.it.examplebicycledebugging.model;

import java.lang.*;

public class Bicycle {
    private String type;
    private int year;
    private double rentalPrice;

    public Bicycle() {
        type = "Not defined";
    }

    public Bicycle(int year, String type) {
        this.type = type;
        this.year = year;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        type = this.type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getrentalprice() {
        return rentalPrice;
    }

    public void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }

    public void increasePrice() {
        rentalPrice += 0.5;
    }

    public void increasePrice(double increase) {
        rentalPrice += increase;
    }

    public double getPricePerYear() {
        double pricePerYear = rentalPrice * 12
        if (year > 2014) {
            pricePerYear *= 0.95;
        }
        return pricePerYear;
    }

    public String getFrameSize(int length) {
        String result = "";
        if (length < 150) {
            result = "M";
        }
        if (length < 190) {
            result = "L";
        }
        if (length >= 190) {
            result = "XL";
        }
        return result;
    }

    public int getTirePressure(int weight) {

        double result = weight / 10;
        if (result < 6) {
            result = 6;
        } else if (result > 9) {
            result = 9;
        }
        return result;

    }

    public String howManyPumps(double bar, int age) {
        String result;
        int competence;

        if (age < 40) {
            competence = 0;
        } else if (age < 50) {
            competence = 30;
        } else if (age < 60) {
            competence = 20;
        } else {
            competence = 10;
        }

        bar *= 10;
        int pumps = (int) bar;

        if (competence == 0) {
            result = pumps + "P";
        } else {
            result = competence + "P,";
            int rest = pumps - competence;
            while (rest - competence >= 0) {
                result = rest + "," + competence + "P";
                rest = pumps - competence;
            }
            if (rest > 0) {
                result = result + "," + rest + "P";
            }
        }
        return result;

    }
}
