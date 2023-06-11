package fact.it.startdesignpattern.model;

public class Advocate extends Profession{
    private Bidder bidder;

    public Advocate() {
    }

    public Bidder getBidder() {
        return bidder;
    }

    public void setBidder(Bidder bidder) {
        this.bidder = bidder;
    }

    public void informClient(){
        System.out.printf("I am the advocate %s %s and I inform my client that there is a new bid for %s\n", bidder.getFirstname(), bidder.getSurname(), bidder.getArtwork().getName());
    }

    public void update() {
        System.out.printf("I am the advocate %s %s and check the new bid for %s\n", bidder.getFirstname(), bidder.getSurname(), bidder.getArtwork().getName());
        informClient();
    }
}
