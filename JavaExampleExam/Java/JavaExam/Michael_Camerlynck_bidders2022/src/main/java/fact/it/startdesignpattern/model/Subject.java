package fact.it.startdesignpattern.model;

import java.util.ArrayList;

public abstract class Subject {
    private ArrayList<Profession> observers;

    public Subject() {
        observers = new ArrayList<>();
    }

    public ArrayList<Profession> getObservers() {
        return observers;
    }

    public void setObservers(ArrayList<Profession> observers) {
        this.observers = observers;
    }

    public void attachObserver(Profession newObserver) {
        observers.add(newObserver);
    }

    public void detachObserver(Profession deleteObserver) {
        observers.remove(deleteObserver);
    }

    public void notifyObserver() {
        for (Profession observer : observers) {
            observer.update();
        }
    }
}
