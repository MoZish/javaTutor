package fact.it.restaurantappstart.model;


import java.util.Observable;

public final class EntranceCounter extends Subject{
    private static EntranceCounter entranceCounter;
    private int number;

    private EntranceCounter() {
        super();
    }

    public static EntranceCounter getInstance() {
        if (entranceCounter == null) {
            entranceCounter = new EntranceCounter();
        }
        return entranceCounter;
    }

    public int getNumber() {
        return entranceCounter.number;
    }

    public void setNumber(int number) {
        entranceCounter.number = number;
        notifyObserver();
    }
}
