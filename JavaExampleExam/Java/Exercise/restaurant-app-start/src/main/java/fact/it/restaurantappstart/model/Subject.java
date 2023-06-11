package fact.it.restaurantappstart.model;

import java.util.ArrayList;

public abstract class Subject {
    private ArrayList<Staff> observers;

    public Subject(){
        observers = new ArrayList<Staff>();
    }

    public void attachObserver(Staff staff){
        observers.add(staff);
    }

    public void detachObserver(Staff staff){
        observers.remove(staff);
    }

    public void notifyObservers(){
        for (Staff staff : observers){
            staff.update();
        }
    }

    public ArrayList<Staff> getObservers() {
        return observers;
    }

    public void setObservers(ArrayList<Staff> observers) {
        this.observers = observers;
    }
}
