package fact.it.startproject.model;

import javax.persistence.Entity;

@Entity
public class Apartment extends Property{
    private int floor;

    public Apartment() {
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public String toString(){
        return String.format("Apartment (%s) on floor: %s with %s contract(s)", this.getCode(), this.floor, (long) this.getContractList().size());
    }
}
