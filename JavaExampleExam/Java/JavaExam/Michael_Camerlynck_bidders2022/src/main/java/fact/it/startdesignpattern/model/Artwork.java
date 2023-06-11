package fact.it.startdesignpattern.model;

public class Artwork extends Subject{
    private String name;
    private double highestBid;

    public Artwork() {
        super();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHighestBid() {
        return highestBid;
    }

    public void setHighestBid(double highestBid) {
        this.highestBid = highestBid;
        notifyObserver();
    }
}
