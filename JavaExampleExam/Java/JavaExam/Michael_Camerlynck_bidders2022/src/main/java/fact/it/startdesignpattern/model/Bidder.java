package fact.it.startdesignpattern.model;

public class Bidder extends Profession{
    private String firstname;
    private String surname;
    private Artwork artwork;

    public Bidder() {
    }

    public Artwork getArtwork() {
        return artwork;
    }

    public void setArtwork(Artwork artwork) {
        this.artwork = artwork;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void update() {
        System.out.printf("I am %s %s and might make a higher bid than %s euro for the artwork %s\n", firstname, surname, artwork.getHighestBid(), artwork.getName());
    }
}
