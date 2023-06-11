package fact.it.restaurantappstart.model;

import java.util.ArrayList;

public abstract class Subject{
    private ArrayList<Staff> observers;

    public Subject() {
        observers = new ArrayList<>();
    }

    public ArrayList<Staff> getObservers() {
        return observers;
    }

    public void setObservers(ArrayList<Staff> observers) {
        this.observers = observers;
    }

    public void attachObserver(Staff newObserver) {
        observers.add(newObserver);
    }

    public void detachObserver(Staff deleteObserver) {
        observers.remove(deleteObserver);
    }

    public void notifyObserver() {
        for (Staff observer : observers) {
            observer.update();
        }
    }
}
